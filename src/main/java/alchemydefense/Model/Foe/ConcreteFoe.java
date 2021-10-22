package alchemydefense.Model.Foe;

import alchemydefense.Utility.BoardObjectType;

/**
 *
 * Class representing a concrete foe. Implements Foe, BoardObject and Health.
 *
 * Date: 2021-09-14
 *
 * @author Willem Brahmstaedt
 *
 * ----- Modified -----
 * Date: 2021-09-19, By Willem; Removed @Override for methods originally from BoardObject
 *
 * Date: 2021-09-20, By Valdemar; Changed method takeDamage to void and added method boolean isAlive instead.
 *
 */
public class ConcreteFoe implements Foe {
    private final int MAX_HP = 100;
    private int currentHP;
    private final String imageFilePath = "/foe.png";
    private final BoardObjectType boardObjectType;

    public ConcreteFoe(){
        this.currentHP = MAX_HP;
        boardObjectType = BoardObjectType.CONCRETE_FOE;
    }

    /**
     * Calculates damage taken
     * @param damageCount Represents how much damage that shall be taken
     */
    @Override
    public void takeDamage(int damageCount) { setCurrentHP(currentHP - damageCount); }

    @Override
    public String getImageFilePath() { return imageFilePath; }

    @Override
    public int getMaxHP() {
        return this.MAX_HP;
    }

    @Override
    public int getCurrentHP() {
        return this.currentHP;
    }

    @Override
    public void setCurrentHP(int hp) {
        this.currentHP = hp;
    }

    @Override
    public boolean isAlive() {
        return getCurrentHP() > 0;
    }

    @Override
    public String toString(){
        return "ConcreteFoe";
    }

    @Override
    public BoardObjectType getBoardObjectType() { return this.boardObjectType; }
}
