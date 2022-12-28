
import java.util.ArrayList;

public class PlanetProperties {
    private final String name;
    private final String group;
    private final int cost;
    private final ArrayList<Double> rentValues;
    private final int position;
    private boolean mortgaged;
    private Player owner;
    private final boolean canBePurchased;
    private int numberOfUpgrades;
    private int perfectPlanet;
    private boolean upgradePurchasedInCurrentTurn;
    private final int upgradeIndex;

    public PlanetProperties(String name, String group, int cost,
                            ArrayList<Double> rentValues, int position, boolean canBePurchased,
                            int upgradeIndex) {
        this.name = name;
        this.group = group;
        this.cost = cost;
        this.rentValues = rentValues;
        this.position = position;
        this.canBePurchased = canBePurchased;
        this.upgradeIndex = upgradeIndex;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<Double> getRentValues() {
        return rentValues;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public String toString() {
        String rent = "\nRentValues: ";
        for (Double rentValue : rentValues) {
            rent += rentValue + " ";
        }
        return "\nName: " + name + "\nGroup: " + group + "\nCost: " + cost
                + "\nPosition: " + position + "\nMortgaged: " + mortgaged
                + rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean canBePurchased() {
        return canBePurchased;
    }

    public int getNumberOfUpgrades() {
        return numberOfUpgrades;
    }

    public void setNumberOfUpgrades(int numberOfUpgrades) {
        this.numberOfUpgrades += numberOfUpgrades;
    }

    public int getNumberOfPerfectPlanet() {
        return perfectPlanet;
    }

    public void setNumberOfPerfectPlanet(int perfectPlanet) {
        this.perfectPlanet += perfectPlanet;
    }

    public int getUpgradeIndex() {
        return upgradeIndex;
    }

}
