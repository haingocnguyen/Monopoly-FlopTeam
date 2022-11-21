package Main;

import Card.Card;
import Entities.PlanetProperties;
import java.util.ArrayList;

public class Player {
    private int Galy;
    private int Mana;
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
        this.Galy = 1000;
        this.Mana = 200;
        this.name = name;
        ownedProperties = new ArrayList<PlanetProperties>();
        outOfJailCards = new ArrayList<>();
    }
    public int Galy(){
        return Galy;
    }
    public void setGaly(int update){
        this.Galy += update;
    }
    public int Mana(){
        return Mana;
    }
    public void setMana(int update){
        this.Mana += update;
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
    public void positionOnBoard(int positionOnGameBoard){
        this.positionOnGameBoard += positionOnGameBoard;
        if (this.positionOnGameBoard >= 40) {
            setGaly(200);
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
}
