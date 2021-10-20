package alchemydefense.Model.Board;

import alchemydefense.Model.Board.Grid.Tile;
import alchemydefense.Model.Board.Grid.TileGrid;
import alchemydefense.Model.Board.Pathfinding.GraphManager;
import alchemydefense.Model.Board.Pathfinding.PathNode;
import alchemydefense.Model.Board.Pathfinding.Pathfinder;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Player.Player;
import alchemydefense.Model.Player.PlayerEventListener;
import alchemydefense.Model.Towers.TowerHierarchy.ITower;
import alchemydefense.Utility.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * A board that manages a two-dimensional grid where towers and enemies can placed.
 *
 * @author Felix Jönsson, Johan Linden, Valdemar Stenhammar, Willem Brahmstaedt
 */
public class ConcreteBoard implements Board {
    private final ArrayList<Tile> tilesWithTowers = new ArrayList<>();

    private final Pathfinder pathfinder;
    private final GraphManager graphManager;

    private final Player currentPlayer;

    private final TileGrid tileGrid;
    private final int width;
    private final int height;
    private final int endGoalX;
    private final int endGoalY;

    /**
     * Constructor that instantiates a new PositionalGrid.
     * @param currentPlayer the player of the game.
     * @param width the width of the board.
     * @param height the height of the board.
     */
    public ConcreteBoard(Player currentPlayer, int width, int height) {
        this.currentPlayer = currentPlayer;
        this.height = height;
        this.width = width;
        this.endGoalX = width - 1;
        this.endGoalY = height / 2;
        tileGrid = new TileGrid(width, height);
        graphManager = new GraphManager(width, height);
        pathfinder = new Pathfinder(graphManager, new Vector(0,2), new Vector(endGoalX, endGoalY)); // Lite fult med först vektorn här?
    }


    public void damageFoes(){
        for(Tile tile : tilesWithTowers){
            ArrayList<Tile> tilesInRange = tile.getTilesInRange(this);
            for(Tile tileInRange : tilesInRange){
                if(tileInRange.hasFoe()){
                    damageFoe(tile, tileInRange);
                    if(!tileInRange.getFoe().isAlive())
                        removeFoe(tileInRange);
                }
            }
        }
    }

    private void damageFoe(Tile tileWithTower, Tile tileWithFoe) {
        int damage = tileWithTower.getTowerDamage();
        tileWithFoe.dealDamageToFoe(damage);
    }

    private void removeFoe(Tile tile) {
        tile.removeFoe();
        currentPlayer.increaseGold(5);
    }

    public BoardObject getBoardObject(Vector point){
        return tileGrid.getBoardObject(point);
    }

    @Override
    public ITower getTower(Vector tile) { return tileGrid.getTower(tile); }

    public Tile getTile(Vector point){
        return tileGrid.getTile(point);
    }

    @Override
    public void placeTower(ITower tower, Vector tileCoordinate) {
        if(tileCoordinate.x == endGoalX && tileCoordinate.y == endGoalY){
            return;
        }
        if(!pathfinder.blocksPath(tileCoordinate) && tileGrid.addTower(tower, tileCoordinate)){
            tilesWithTowers.add(tileGrid.getTile(tileCoordinate));
            graphManager.blockPathNode(new Vector(tileCoordinate.x, tileCoordinate.y));
        }
    }

    public void removeTower(Vector point) {
        tilesWithTowers.remove(tileGrid.getTile(point));
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
        Tile[][] grid = tileGrid.getGrid();
        if(grid[endGoalX][endGoalY].hasFoe()) {
            grid[endGoalX][endGoalY].removeFoe();
            currentPlayer.decreaseOneHp();
        }

    }

    //NEEDS DOCS AND REFINEMENT, CAN MAKE SHORTER BY CREATING NEW METHODS IN CLASSES THAT'S BEING CALLED?
    public void moveFoes(){
        Tile[][] grid = tileGrid.getGrid();
        ArrayList<Foe> foeList = new ArrayList<>();
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[i].length; j++) {
                if(grid[i][j].hasFoe() && !((i==11) && (j==2)) && !grid[i][j].getFoe().hasBeenUpdated()){
                    Foe foe = grid[i][j].removeFoe();
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
        currentPlayer.addPlayerEventListener(listener);
    }
}
