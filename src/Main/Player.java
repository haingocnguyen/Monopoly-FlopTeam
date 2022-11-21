package Main;
import java.util.ArrayList;
public class Player {
    private int Galy;
    private int Mana;
    private String name;
    private int positionOnGameBoard;
    private boolean inJail;
    private boolean passedGo;
    private int turnsInJail;
    private boolean isBankrupt;
    private ArrayList<Card> outOfJailCards;
    private ArrayList <...> ownedProperties;
    public Player(String name){
        // Default galy and mana values
        this.Galy = 1000;
        this.Mana = 200;
        this.name = name;
        ownedProperties = new ArrayList<...>();
        outOfJailCards = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGaly(double update) {
        this.Galy += update;
    }
    public int getPositionOnGameBoard() {
        return positionOnGameBoard;
    }
    public boolean didPassGo() {
        return passedGo;
    }
    public void setPassedGo(boolean passedGo) {
        this.passedGo = passedGo;
    }
    public void setPositionOnGameBoard(int positionOnGameBoard) {
        this.positionOnGameBoard += positionOnGameBoard;
        if (this.positionOnGameBoard >= 40) {
            setGaly(200);
            setPassedGo(true);
            this.positionOnGameBoard = this.positionOnGameBoard % 40;
        }
    }
    public ArrayList<...> getOwnedProperties() {
        return ownedProperties;
    }
    public void setOwnedProperties(ArrayList<...> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }
    public int getNumberOfGetOutOfJailCards() {
        return outOfJailCards.size();
    }
    public void addGetOutOfJailCard(Card card) {
        outOfJailCards.add(card);
    }
    public ArrayList<Card> getOutOfJailCards() {
        return outOfJailCards;
    }
    public boolean isInJail() {
        return inJail;
    }
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
}
