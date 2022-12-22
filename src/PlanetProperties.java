
import java.util.ArrayList;

public class PlanetProperties {
    private String name;
    private String group;
    private int cost;
    private ArrayList<Double> rentValues;
    private int position;
    private boolean mortgaged;
    private Player owner;
    private boolean canBePurchased;
    private int numberOfUpgrades;
    private int perfectPlanet;
    private boolean upgradePurchasedInCurrentTurn;
    private int upgradeIndex;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<Double> getRentValues() {
        return rentValues;
    }

    public void setRentValues(ArrayList<Double> rentValues) {
        this.rentValues = rentValues;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public void setCanBePurchased(boolean canBePurchased) {
        this.canBePurchased = canBePurchased;
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

    public boolean isUpgradePurchasedInCurrentTurn() {
        return upgradePurchasedInCurrentTurn;
    }

    public void setUpgradePurchasedInCurrentTurn(
            boolean upgradePurchasedInCurrentTurn) {
        this.upgradePurchasedInCurrentTurn = upgradePurchasedInCurrentTurn;
    }

    public int getUpgradeIndex() {
        return upgradeIndex;
    }

    public void setUpgradeIndex(int upgradeIndex) {
        this.upgradeIndex = upgradeIndex;
    }
}
