package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.Board;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.TowerHierarchy.Tower;
import alchemydefense.Utility.Vector2Int;

import java.util.ArrayList;


public class PositionalCell {
    private final Vector2Int cellCoordinate;
    private boolean isOccupiedByTower = false;
    private Tower tower;
    private Foe foe;
    private boolean updated = false;

    public PositionalCell(int x, int y){
        cellCoordinate = new Vector2Int(x,y);
    }
    public PositionalCell(Vector2Int point){
        cellCoordinate = point;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupiedByTower = isOccupied;
    }
    public void setUpdated(boolean b){
        updated = b;
    }

    public boolean hasFoe(){
        return foe != null;
    }
    public boolean isOccupiedByTower() {
        return isOccupiedByTower;
    }

    public Vector2Int getCellCoordinate(){
        return cellCoordinate;
    }
    public boolean isUpdated() { return updated; }

    public BoardObject getBoardObject(){
        if(tower != null){
            return tower;
        }
        else if(foe != null){
            return foe;
        }
        return null;
    }

    public Tower getTower(){
        return tower;
    }
    public Foe getFoe(){
        return foe;
    }

    public void addTower(Tower tower) {
        if(isOccupiedByTower) return;
        isOccupiedByTower = true;
        this.tower = tower;
    }

    public void clear(){
        foe = null;
        tower = null;
        isOccupiedByTower = false;
    }

    public ArrayList<PositionalCell> getPositionalCellsWithinRange(Board board){
        ArrayList<PositionalCell> cellsInRange = new ArrayList<>();

        if(tower == null || tower.getRange() == 0){
           return cellsInRange;
        }

        addCellsWithinRange(cellsInRange, board);

        return cellsInRange;
    }

    private void addCellsWithinRange(ArrayList<PositionalCell> cellsInRange, Board board) {
        int range = tower.getRange();

        for (int y = -range; y <= range; y++) {
            for (int x = -range; x <= range ; x++) {
                if(x == 0 && y == 0){
                    continue;
                }
                if(Math.abs(x) + Math.abs(y) > range){
                    continue;
                }
                addCell(cellsInRange, board, x, y);
            }
        }
    }

    private void addCell(ArrayList<PositionalCell> cellsInRange, Board board, int x, int y) {
        Vector2Int currentCellPosition = new Vector2Int(cellCoordinate.x + x, cellCoordinate.y + y);
        if(currentCellPosition.x >= 0 && currentCellPosition.x < board.getBoardWidth() &&
                currentCellPosition.y >= 0 && currentCellPosition.y < board.getBoardHeight()){
            cellsInRange.add(board.getCell(currentCellPosition));
        }
    }

    public Foe removeFoe(){
        Foe foe = this.foe;
        clear();
        return foe;
    }

    //Allow multiple foes? Possible solution = store foes as a list.
    public void addFoe(Foe foe){
        if(!hasFoe()){
            this.foe = foe;
        }
    }

    @Override
    public String toString(){
        return "(" + cellCoordinate.x + ", " + cellCoordinate.y + ")";
    }
}
