package Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ChanceCard extends Card {
    private boolean chanceCardPicked;
    private JButton chanceButton;
    private DeckOfChanceAndFortuneCards deck;
    public ChanceCard(int id) {
        super(id);
    }

    // Waiting for other classes to active
//    private void followChanceCard9() {
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has spent M" + this.paymentDueAmount + " on general repairs on his properties \n";
//        this.logText.append(this.log);
//    }
//
//    private void followChanceCard10() {
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-15.0);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " paid poor tax: M15" + "\n";
//        this.logText.append(this.log);
//    }
//
//    private void followChanceCard13() {
//        for(int i = 0; i < this.players.size(); ++i) {
//            if (i != this.playerIndex && !((Player)this.players.get(i)).isBankrupt()) {
//                ((Player)this.players.get(i)).setMoneyHeld(50.0);
//                ((JLabel)this.balanceLabels.get(i)).setText("E" + ((Player)this.players.get(i)).getMoneyHeld());
//            }
//        }
//
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " paid each of other players M50" + "\n";
//        this.logText.append(this.log);
//    }
    // dealChanceCard == ChanceCardActive
    private void ChanceCardActive() {
        this.chanceCardPicked = true;
//        int position = ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard();
        BufferedImage img;
        switch (this.deck.dealChanceCard()) {
            case 0:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance00.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                }

//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(40 - ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard());
//                this.adjustPlayerPosition();
                break;
            case 1:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance01.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                }

//                if (position > 24) {
//                    position = 24 - position + 40;
//                } else {
//                    position = 24 - position;
//                }
//
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 2:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance02.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                }

//                if (position < 12) {
//                    position = 12 - position;
//                } else if (position < 28) {
//                    position = 28 - position;
//                } else {
//                    position = 52 - position;
//                }
//
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.sentByChanceCard = true;
//                this.adjustPlayerPosition();
                break;
            case 3:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance03.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                }

//                byte position;
//                if (position == 7) {
//                    position = 8;
//                } else if (position == 22) {
//                    position = 3;
//                } else {
//                    position = 9;
//                }

//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                if (((Entity)this.entities.getEntities().get(((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner() != null && ((Entity)this.entities.getEntities().get(((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner().getName() != ((Player)this.players.get(this.playerIndex)).getName()) {
//                    this.sentByChanceCard = true;
//                }
//
//                this.adjustPlayerPosition();
                break;
            case 4:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance04.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                }

//                if (position == 7) {
//                    position = 4;
//                } else {
//                    position = 51 - position;
//                }
//
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 5:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance05.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                }

//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(50.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received M50 divident from the bank \n";
//                this.logText.append(this.log);
                break;
            case 6:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance06.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                }

//                ((Player)this.players.get(this.playerIndex)).addGetOutOfJailCard(this.deck.getChanceCard(6));
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setText("get out of jail cards : " + ((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards());
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setVisible(true);
//                this.generateSellGetOutOfJailCardComboBox();
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " received get out of Jail card \n";
//                this.logText.append(this.log);
                break;
            case 7:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance07.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                }

//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(-3);
//                this.adjustPlayerPosition();
                break;
            case 8:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance08.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                }

//                if (((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards() == 0) {
//                    position = 10 - position;
//                    ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                    this.finishTurn.setEnabled(true);
//                    this.rollTheDice.setEnabled(false);
//                    ((Player)this.players.get(this.playerIndex)).setInJail(true);
//                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " went to Jail" + "\n";
//                    this.logText.append(this.log);
//                    this.adjustPlayerPosition();
//                } else {
//                    this.gamePrompt.setText("Do you want to use your get out of jail card?");
//                    this.useGetOutOfJailCard.setVisible(true);
//                    this.dontUseGetOutOfJailCard.setVisible(true);
//                    this.rollTheDice.setEnabled(false);
//                    this.finishTurn.setEnabled(false);
                //}
                break;
            case 9:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance09.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                }

//                this.paymentDueAmount = 0.0;
//                Iterator var23 = ((Player)this.players.get(this.playerIndex)).getOwnedProperties().iterator();
//
//                while(var23.hasNext()) {
//                    Entity entity = (Entity)var23.next();
//                    if (entity.getNumberOfHouses() > 0) {
//                        this.paymentDueAmount += (double)(entity.getNumberOfHouses() * 25);
//                    }
//
//                    if (entity.getNumberOfHotels() > 0) {
//                        this.paymentDueAmount += 100.0;
//                    }
//                }
//
//                if (this.paymentDueAmount > 0.0) {
//                    if (this.paymentDueAmount <= ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                        this.followChanceCard9();
//                    } else {
//                        this.paymentDue = true;
//                        this.arrearsIndex = 9;
//                    }
//                }
                break;
            case 10:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance10.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                }

//                this.paymentDueAmount = 15.0;
//                if (this.paymentDueAmount <= ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                    this.followChanceCard10();
//                } else {
//                    this.paymentDue = true;
//                    this.arrearsIndex = 10;
//                }
                break;
            case 11:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance11.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                }

//                position = 45 - position;
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 12:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance12.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                }

//                position = 39 - position;
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 13:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance13.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                }

                int counter = 0;

//                for(int i = 0; i < this.players.size(); ++i) {
//                    if (i != this.playerIndex && !((Player)this.players.get(i)).isBankrupt()) {
//                        ++counter;
//                    }
//                }

//                this.paymentDueAmount = (double)(counter * 50);
//                if (this.paymentDueAmount > ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                    this.paymentDue = true;
//                    this.arrearsIndex = 13;
//                } else {
//                    this.followChanceCard13();
//                }
                break;
            case 14:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance14.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                }

//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(150.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " received M150 from the bank" + "\n";
//                this.logText.append(this.log);
                break;
            case 15:
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance15.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                }

//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " received M100 from the bank" + "\n";
//                this.logText.append(this.log);
                break;
        }
    }
}
