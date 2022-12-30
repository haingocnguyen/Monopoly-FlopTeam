import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> outOfJailCards;
    private final ArrayList<PlanetProperties> ownedProperties;
    private double moneyHeld;
    private double manaHeld;
    private boolean passedGo;
    private int positionOnGameBoard;
    private boolean inJail;
    private int turnsInJail;
    private boolean isBankrupt;

    public Player(String name) {
        // Default Galy and Mana values
        this.moneyHeld = 1500;
        this.manaHeld = 100;
        this.name = name;
        ownedProperties = new ArrayList<>();
        outOfJailCards = new ArrayList<>();
    }

    public double getMoneyHeld() {
        return moneyHeld;
    }

    public void setMoneyHeld(double update) {
        this.moneyHeld += update;
    }

    public double getManaHeld() {
        return manaHeld;
    }

    public void setManaHeld(double update) {
        this.manaHeld += update;
    }

    public String getName() {
        return name;
    }

    public boolean didPassGo() {
        return passedGo;
    }

    public void setPassedGo(boolean passedGo) {
        this.passedGo = passedGo;
    }

    public int getPositionOnGameBoard() {
        return this.positionOnGameBoard;
    }

    public void positionOnBoard(int positionOnGameBoard) {
        this.positionOnGameBoard += positionOnGameBoard;
        if (this.positionOnGameBoard >= 40) {
            setMoneyHeld(200);
            setPassedGo(true);
            this.positionOnGameBoard = this.positionOnGameBoard % 40;
        }
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getNumberOfGetOutOfJailCards() {
        return outOfJailCards.size();
    }

    public void addGetOutOfJailCard(Card card) {
        outOfJailCards.add(card);
    }

    public int getTurnsInJail() {
        return turnsInJail;
    }

    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }

    public ArrayList<Card> getOutOfJailCards() {
        return outOfJailCards;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    public ArrayList<PlanetProperties> getOwnedProperties() {
        return ownedProperties;
    }
}
