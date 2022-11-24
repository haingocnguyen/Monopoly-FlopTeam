package Main;

import Card.Card;
import Entities.PlanetProperties;
import java.util.ArrayList;

public class Player {
    private double moneyHeld;
    private double manaHeld;
    private String name;
    private boolean passedGo;
    private int positionOnGameBoard;
    private boolean inJail;
    private ArrayList<Card> outOfJailCards;
    private int turnsInJail;
    private ArrayList<PlanetProperties> ownedProperties;
    private boolean isBankrupt;
    
    public Player(String name){
        // Default galy and mana values
        this.moneyHeld = 1000;
        this.manaHeld = 200;
        this.name = name;
        ownedProperties = new ArrayList<PlanetProperties>();
        outOfJailCards = new ArrayList<>();
    }
    public double getMoneyHeld(){
        return moneyHeld;
    }
    public void setMoneyHeld(double update){
        this.moneyHeld += update;
    }
    public double getManaHeld(){
        return manaHeld;
    }
    public void setManaHeld(double update){
        this.manaHeld += update;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean didPassGo(){
        return passedGo;
    }
    public void setPassedGo(boolean passedGo){
        this.passedGo = passedGo;
    }
    public int getPositionOnGameBoard() {
        return this.positionOnGameBoard;
    }
    public void positionOnBoard(int positionOnGameBoard){
        this.positionOnGameBoard += positionOnGameBoard;
        if (this.positionOnGameBoard >= 40) {
            setMoneyHeld(200);
            setPassedGo(true);
            this.positionOnGameBoard = this.positionOnGameBoard % 40;
        }
    }
    public boolean isInJail(){
        return inJail;
    }
    public void setInJail(boolean inJail){
        this.inJail = inJail;
    }
    public int getNumberOfGetOutOfJailCards(){
        return outOfJailCards.size();
    }
    public void addGetOutOfJailCard(Card card){
        outOfJailCards.add(card);
    }
    public int getTurnsInJail(){
        return turnsInJail;
    }
    public void setTurnsInJail(int turnsInJail){
        this.turnsInJail = turnsInJail;
    }
    public ArrayList<Card> getOutOfJailCards() {
        return outOfJailCards;
    }
    public boolean isBankrupt(){
        return isBankrupt;
    }
    public void setBankrupt(boolean isBankrupt){
        this.isBankrupt = isBankrupt;
    }
    public ArrayList<PlanetProperties> getOwnedProperties() {
        return ownedProperties;
    }
    public void setOwnedProperties(ArrayList<PlanetProperties> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }

}
