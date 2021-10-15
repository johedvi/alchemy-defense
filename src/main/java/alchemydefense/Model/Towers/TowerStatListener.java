package alchemydefense.Model.Towers;

/**
 * Interface for delivering a towers stats.
 *
 * @author Valdemar Stenhammar
 *
 * Date: 2021-10-13.
 */
public interface TowerStatListener {

    /**
     * Displays the towers stats.
     * @param towerType the type of tower.
     * @param range the range of the tower.
     * @param damage the damage of the tower.
     * @param sellPrice the sell price of the tower.
     */
    void displayTowerStats(String towerType, int range, int damage, int sellPrice);

}
