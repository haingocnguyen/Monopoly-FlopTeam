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
//    private void followChanceCard1() {
//        for(int i = 0; i < this.players.size(); ++i) {
//            if (i != this.playerIndex && !((Player)this.players.get(i)).isBankrupt()) {
//                ((Player)this.players.get(i)).setMoneyHeld(50.0);
//                ((JLabel)this.balanceLabels.get(i)).setText("E" + ((Player)this.players.get(i)).getMoneyHeld());
//            }
//        }
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " paid each of other players 50 Galy on success on Alpha-leap" + "\n";
//        this.logText.append(this.log);
//    }
    //    private void followChanceCard3() {
//        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
//        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 30 mana due to energy leak" + "\n";
//        this.logText.append(this.log);
//    }
    //    private void followChanceCard16() {
//        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
//        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 150 mana due to black hole edge" + "\n";
//        this.logText.append(this.log);
//    }
    //    private void followChanceCard19() {
//        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
//        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 50 mana due to gamma ray burst" + "\n";
//        this.logText.append(this.log);
//    }

    // dealChanceCard == ChanceCardActive
    private void ChanceCardActive() {
        this.chanceCardPicked = true;
//        int position = ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard();
        BufferedImage img;
        switch (this.deck.dealChanceCard()) {
            case 1:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance01.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                }

//                int counter = 0;
//
//                for(int i = 0; i < this.players.size(); ++i) {
//                    if (i != this.playerIndex && !((Player)this.players.get(i)).isBankrupt()) {
//                        ++counter;
//                    }
//                }
//                this.paymentDueAmount = (double)(counter * 50);
//                if (this.paymentDueAmount > ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                    this.paymentDue = true;
//                    this.arrearsIndex = 1;
//                } else {
//                    this.followChanceCard1();
//                }
                break;
            case 2:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance2.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                }

//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(50.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 50 Galy for meeting a gold meteorite" + "\n";
//                this.logText.append(this.log);
                break;
            case 3:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance3.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                }

//                this.manaDueAmount = 30.0;
//                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
//                    this.followChanceCard3();
//                } else {
//                    this.manaDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 4:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance4.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                }

//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(-3);
//                this.adjustPlayerPosition();
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has turned 3 steps back to avoid asteroid hit\n";
//                this.logText.append(this.log);
                break;
            case 5:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance05.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                }

//                if (position == 7) {
//                    position = 9;
//                } else {
//                    position = 56 - position;
//                }
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 6:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance6.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                }
//
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
//                if (this.paymentDueAmount > 0.0) {
//                    if (this.paymentDueAmount <= ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                        this.followChanceCard9();
//                    } else {
//                        this.paymentDue = true;
//                        this.arrearsIndex = 9;
//                    }
//                }
//                break;
            case 7:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance07.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                }

//                //int position = ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard();
////                if (((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards() == 0) {
////                    position = 10 - position;
////                    ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
////                    this.finishTurn.setEnabled(true);
////                    this.rollTheDice.setEnabled(false);
////                    ((Player)this.players.get(this.playerIndex)).setInJail(true);
////                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " went to Jail" + "\n";
////                    this.logText.append(this.log);
////                    this.adjustPlayerPosition();
                ////    ((Player)this.players.get(this.playerIndex)).setManaHeld(0);
////                    ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
////                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost all the mana due to colliding high-velocity stars" + "\n";
////                    this.logText.append(this.log);
////                } else {
////                    this.gamePrompt.setText("Do you want to use your get out of jail card?");
////                    this.useGetOutOfJailCard.setVisible(true);
////                    this.dontUseGetOutOfJailCard.setVisible(true);
////                    this.rollTheDice.setEnabled(false);
////                    this.finishTurn.setEnabled(false);
                //      ((Player)this.players.get(this.playerIndex)).setManaHeld(+500.0);
//                      ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//                      this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has gained 500 mana from ISS gift" + "\n";
//                      this.logText.append(this.log);
////                }
               break;
            case 8:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance8.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                }

//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(150.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 150 Galy from meeting peer-to-peer spacecraft" + "\n";
//              this.logText.append(this.log);
                break;
            case 9:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance9.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                }

//                ((Player)this.players.get(this.playerIndex)).addGetOutOfJailCard(this.deck.getFortuneCard(3));
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setText("get out of jail cards : " + ((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards());
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setVisible(true);
//                this.generateSellGetOutOfJailCardComboBox();
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received get out of Jail card \n";
//                this.logText.append(this.log);
                break;
            case 10:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance10.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
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

            case 11:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance11.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                }

//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(40 - ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard());
//                this.adjustPlayerPosition();
                break;
            case 12:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance12.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                }

//                position = 41 - position;
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 13:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance13.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                }
//                if (position == 7) {
//                    position = 22;
//                } else if (position == 22){
//                    position = 7;
//                } else {
//                    position = 69 - position;
//                }
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;
            case 14:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance14.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                }

//                position = 45 - position;
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                this.adjustPlayerPosition();
                break;

            case 15:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance15.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                }

//                byte position;
//                if (position == 7) {
//                    position = 8;
//                } else if (position == 22) {
//                    position = 3;
//                } else {
//                    position = 9;
//                }
//
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(position);
//                if (((Entity)this.entities.getEntities().get(((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner() != null && ((Entity)this.entities.getEntities().get(((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner().getName() != ((Player)this.players.get(this.playerIndex)).getName()) {
//                    this.sentByChanceCard = true;
//                }
//                this.adjustPlayerPosition();
                break;
            case 16:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance16.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                }
//                this.manaDueAmount = 150.0;
//                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
//                    this.followChanceCard16();
//                } else {
//                    this.manaDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 17:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance17.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy from supply ship coming" + "\n";
//              this.logText.append(this.log);
                break;
            case 18:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance18.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy from new matter founding" + "\n";
//              this.logText.append(this.log);
                break;
            case 19:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance19.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                }
//                this.manaDueAmount = 50.0;
//                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
//                    this.followCommunityCard19();
//                } else {
//                    this.manaDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 20:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/chance20.jpg"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 Galy from new batteries" + "\n";
//              this.logText.append(this.log);
                break;
        }
    }
}
