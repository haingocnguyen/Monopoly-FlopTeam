public class Player {
    private String playerName;
    private int playerMana;
    private int playerMoney;
    private int level;

    public Player(){
        this.playerMana = 500;
        this.playerMoney = 2000;
        this.level = 1;
    }

    public String getPlayerName(){

        return playerName;
    }
    public void setPlayerName(String playerName){

        this.playerName = playerName;
    }
    public int getPlayerMana(){

        return playerMana;
    }
    public void setPlayerMana(int playerMana){

        this.playerMana = playerMana;
    }
    public int getPlayerMoney(){

        return playerMoney;
    }
    public void setPlayerMoney(int playerMoney){

        this.playerMoney = playerMoney;
    }
    public int getLevel(){

        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }

    public void checkMana(int playerMana){

        if (playerMana >= 0 && playerMana <999){
            this.setLevel(1);
        }
        if( playerMana >1000 && playerMana <= 1500){
            this.setLevel(2);
        }
        System.out.println(getPlayerName()+"'s level is"+ getLevel()+"\n");
    }

    public void payRent(int amount, Player target){

        this.playerMoney -= amount;
        target.playerMoney += amount;
    }

    public void crash(){
        this.setPlayerMana(0);
        System.out.println(this.getPlayerName()+"'s mana is: "+ getPlayerMana()+"\n");
    }

    public void charging(int playerMana, int amount){
        this.playerMana += amount;
        this.checkMana(playerMana);
    }

    public void receiveFromBank(int amount){
        this.playerMoney += amount;
        System.out.println(this.getPlayerName()+"'s money is: "+ getPlayerMoney()+"\n");
    }
    public void display(){
        System.out.println(this.getPlayerName()+"'s money is: "+ getPlayerMoney());
        System.out.println(this.getPlayerName()+"'s mana is: "+ getPlayerMana()+"\n");
    }
}
