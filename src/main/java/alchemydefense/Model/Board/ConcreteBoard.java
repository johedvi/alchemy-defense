package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.Tile;
import alchemydefense.Model.Board.Grid.TileGrid;
import alchemydefense.Model.Board.Pathfinding.GraphManager;
import alchemydefense.Model.Board.Pathfinding.PathNode;
import alchemydefense.Model.Board.Pathfinding.Pathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.ITower;
import alchemydefense.Utility.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * A board that manages a two-dimensional grid where towers and enemies can placed.
 *
 * @Author: Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class ConcreteBoard implements Board {
    private final ArrayList<Tile> cellsWithTowers = new ArrayList<>();

    private final Pathfinder pathfinder;
    private final GraphManager graphManager;

    private final static Player player = Player.getPlayer();

    private final TileGrid tileGrid;
    private final int width;
    private final int height;
    private final int endGoalX;
    private final int endGoalY;

    /**
     * Constructor that instantiates a new PositionalGrid.
     */
    public ConcreteBoard(int width, int height){
        this.height = height;
        this.width = width;
        this.endGoalX = width - 1;
        this.endGoalY = height / 2;
        tileGrid = new TileGrid(width, height);
        graphManager = new GraphManager(width, height);
        pathfinder = new Pathfinder(graphManager, new Vector(0,2), new Vector(endGoalX, endGoalY)); // Lite fult med först vektorn här?
    }


    public void damageFoes(){
        for(Tile cell : cellsWithTowers){
            ArrayList<Tile> cellsInRange = cell.getPositionalCellsWithinRange(this);
            for(Tile cellInRange : cellsInRange){
                if(cellInRange.hasFoe()){
                    damageFoe(cell, cellInRange);
                    if(!cellInRange.getFoe().isAlive())
                        removeFoe(cellInRange);
                }
            }
        }
    }

    private void damageFoe(Tile cellTower, Tile cellFoe) {
        int damage = cellTower.getTower().getDamage();
        cellFoe.getFoe().takeDamage(damage);
    }

    private void removeFoe(Tile cell) {
        cell.removeFoe();
        player.increaseGold(5);
    }

    public BoardObject getBoardObject(Vector point){
        return tileGrid.getBoardObject(point);
    }

    @Override
    public ITower getTower(Vector cell) { return tileGrid.getTower(cell); }

    public Tile getCell(Vector point){
        return tileGrid.getCell(point);
    }

    @Override
    public void placeTower(ITower tower, Vector cellCoordinate) {
        if(cellCoordinate.x == endGoalX && cellCoordinate.y == endGoalY){
            return;
        }
        if(!pathfinder.blocksPath(cellCoordinate) && tileGrid.addTower(tower, cellCoordinate)){
            cellsWithTowers.add(tileGrid.getCell(cellCoordinate));
            graphManager.blockPathNode(new Vector(cellCoordinate.x, cellCoordinate.y));
        }
    }

    public void removeTower(Vector point) {
        cellsWithTowers.remove(tileGrid.getCell(point));
        tileGrid.remove(point);
        graphManager.unblockPathNode(point);
    }

    @Override
    public int getBoardWidth() {
        return width;
    }

    @Override
    public int getBoardHeight() {
        return height;
    }

    @Override
    public void updateFoes() {
        damageFoes();
        moveFoes();

    }

    public void addFoe(Foe foe){
        Vector startPos = new Vector(0, (int) (getBoardHeight() * Math.random()));
        tileGrid.addFoe(foe, startPos);
    }

    public void foeReachedEnd() {
        Tile[][] cellGrid = tileGrid.getGrid();
        if(cellGrid[endGoalX][endGoalY].hasFoe()) {
            cellGrid[endGoalX][endGoalY].removeFoe();
            player.decreaseOneHp();

        }

    }

    //NEEDS DOCS AND REFINEMENT, CAN MAKE SHORTER BY CREATING NEW METHODS IN CLASSES THAT'S BEING CALLED?
    public void moveFoes(){
        Tile[][] cellGrid = tileGrid.getGrid();
        ArrayList<Foe> foeList = new ArrayList<>();
        for(int i=0; i< cellGrid.length; i++) {
            for(int j=0; j< cellGrid[i].length; j++) {
                if(cellGrid[i][j].hasFoe() && !((i==11) && (j==2)) && !cellGrid[i][j].getFoe().hasBeenUpdated()){
                    Foe foe = cellGrid[i][j].removeFoe();
                    foeList.add(foe);
                    List<PathNode> path = null;
                    try {
                        path = pathfinder.generateNewPath(new Vector(i,j), new Vector(endGoalX, endGoalY));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Vector nextVector = path.get(1).getCoordinateVector();
                    tileGrid.addFoe(foe, nextVector);
                    foe.setUpdateFlag(true);
                }
            }
        }
        for (Foe foe : foeList){
            foe.setUpdateFlag(false);
        }
        foeList.clear();
    }

    public void addPlayerEventListener(PlayerEventListener listener) {
        player.addPlayerEventListener(listener);
    }
}
