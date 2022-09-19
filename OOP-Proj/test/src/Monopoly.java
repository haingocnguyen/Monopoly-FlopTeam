import java.util.*;

public class    Monopoly {
    public static void main(String[] args){

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        player1.setPlayerName("Tu");
        player2.setPlayerName("Kiet");
        player3.setPlayerName("Ngoc");
        player4.setPlayerName("Dieu");

        player1.display();
        player2.display();
        player3.display();
        player4.display();

        player3.payRent(20,player1);
        player4.crash();
        player2.receiveFromBank(10);


    }
}
