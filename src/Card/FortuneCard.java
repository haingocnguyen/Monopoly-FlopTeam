package Card;
import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.IOException;
        import java.util.Iterator;

public class FortuneCard extends Card {
    private boolean fortuneCardPicked;
    private JButton communityChest;
    private DeckOfChanceAndFortuneCards deck;
    public FortuneCard(int id) {
        super(id);
    }

    // Waiting for other classes to active
    //    private void followCommunityCard5() {
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has paid 50 Galy for maintenance fee" + "\n";
//        this.logText.append(this.log);
//    }
    //    private void followCommunityCard6() {
//        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
//        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has paid 50 Galy for space garage fee" + "\n";
//        this.logText.append(this.log);
//    }

    // setMoneyHeld = setManaHeld || balanceLabels = energyLabels || paymentDueAmount = manaDueAmount
    //    private void followCommunityCard8() {
//        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
//        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 150 mana due to letting the sub-spacecraft to explore" + "\n";
//        this.logText.append(this.log);
//    }

    //    private void followCommunityCard20() {
//        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
//        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 100 mana due to losing connection" + "\n";
//        this.logText.append(this.log);
//    }

    // dealCommunityCard == FortuneCardActive
    private void FortuneCardActive() {
        this.fortuneCardPicked = true;
        int counter;
        BufferedImage img;
        int i;
        switch (this.deck.dealFortuneCard()) {
            case 1:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune1.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                }
//                this.paymentDueAmount = 0.0;
//                Iterator var4 = ((Player)this.players.get(this.playerIndex)).getOwnedProperties().iterator();

//                while(var4.hasNext()) {
//                    PlanetProperties PlanetProperties = (PlanetProperties)var4.next();
//                    if (PlanetProperties.getNumberOfHouses() > 0) {
//                        this.paymentDueAmount += (double)(PlanetProperties.getNumberOfHouses() * 40);
//                    }
//                    if (PlanetProperties.getNumberOfHotels() > 0) {
//                        this.paymentDueAmount += 115.0;
//                    }
//                }
//                if (this.paymentDueAmount > 0.0) {
//                    if (this.paymentDueAmount <= ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
//                        this.followCommunityCard1();
//                    } else {
//                        this.paymentDue = true;
//                        this.arrearsIndex = 112;
//                    }
//                }
                break;
            case 2:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune2.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                }

//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(10.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 10 Galy for being a Miss Universe 2023" + "\n";
//                this.logText.append(this.log);
                break;
            case 3:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune3.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                }

//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy for meeting a diamond meteorite\n";
//              this.logText.append(this.log);
                break;
            case 4:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune4.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 Galy from the bank" + "\n";
//              this.logText.append(this.log);
                break;
            case 5:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune5.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                }

//                this.paymentDueAmount = 50.0;
//                if (((Player)this.players.get(this.playerIndex)).getMoneyHeld() >= this.paymentDueAmount) {
//                    this.followCommunityCard5();
//                } else {
//                    this.paymentDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 6:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune6.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                }

//                this.paymentDueAmount = 100.0;
//                if (((Player)this.players.get(this.playerIndex)).getMoneyHeld() >= this.paymentDueAmount) {
//                    this.followCommunityCard6();
//                } else {
//                    this.paymentDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 7:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune7.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 Galy from the alien gift" + "\n";
//              this.logText.append(this.log);
                break;
            case 8:         // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune8.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                }
                // paymentDue = manaDue
//                this.manaDueAmount = 150.0;
//                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
//                    this.followCommunityCard8();
//                } else {
//                    this.manaDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
            case 9:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune9.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(25.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 25 Galy from Alien's spacecraft" + "\n";
//              this.logText.append(this.log);
                break;
            case 10:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune10.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                }
//                ((Player)this.players.get(this.playerIndex)).setPositionOnGameBoard(40 - ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard());
//                this.adjustPlayerPosition();
                //((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy from the government" + "\n";
//                this.logText.append(this.log);
                break;
                case 11:       // DONE
                    try {
                        img = ImageIO.read(this.getClass().getResource("resources/fortune11.jpg"));
                        this.communityChest.setIcon(new ImageIcon(img));
                    } catch (IOException var10) {
                    }

                    counter = 0;

//                for(i = 0; i < this.players.size(); ++i) {
//                    if (i != this.playerIndex) {
//                        ((Player)this.players.get(i)).setMoneyHeld(-50.0);
//                        ++counter;
//                        ((JLabel)this.balanceLabels.get(i)).setText("E" + ((Player)this.players.get(i)).getMoneyHeld());
//                    }
//                }
//
//                ((Player)this.players.get(this.playerIndex)).setMoneyHeld((double)(counter * 50));
//                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received from each of other players 50 Galy" + "\n";
//                this.logText.append(this.log);
                    break;
            case 12:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune12.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy for awarding the Universe Oldie Pension" + "\n";
//              this.logText.append(this.log);
                break;
                // getCommunityCard = getFortuneCard
            case 13:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune13.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                }

//                ((Player)this.players.get(this.playerIndex)).addGetOutOfJailCard(this.deck.getFortuneCard(3));
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setText("get out of jail cards : " + ((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards());
//                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setVisible(true);
//                this.generateSellGetOutOfJailCardComboBox();
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received get out of Jail card \n";
//                this.logText.append(this.log);
                //((Player)this.players.get(this.playerIndex)).setManaHeld(+500.0);
//                 ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has gained 500 mana from ISS gift" + "\n";
//                this.logText.append(this.log);
                break;
            case 14:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune14.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                }

//                int position = ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard();
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
//                }
//              ((Player)this.players.get(this.playerIndex)).setManaHeld(0);
//              ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//               this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost all the mana due to colliding high-velocity stars" + "\n";
//              this.logText.append(this.log);
                break;
            case 15:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune15.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(50.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 50 Galy from lucky money" + "\n";
//              this.logText.append(this.log);
                break;
            case 16:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune16.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                }
//              ((Player)this.players.get(this.playerIndex)).setMoneyHeld(20.0);
//              ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 20 Galy for doing overtime discovery" + "\n";
//              this.logText.append(this.log);
                break;
            case 17:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune17.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                }
//              ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
//              ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from solar energy charging" + "\n";
//              this.logText.append(this.log);
                break;
            case 18:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune18.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                }
//              ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
//              ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from radioisotope thermoelectric generators" + "\n";
//              this.logText.append(this.log);
                break;
            case 19:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune19.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                }
//              ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
//              ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
//              this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from fuel cells" + "\n";
//              this.logText.append(this.log);
                break;
            case 20:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune20.jpg"));
                    this.communityChest.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                }
//                this.manaDueAmount = 100.0;
//                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
//                    this.followCommunityCard20();
//                } else {
//                    this.manaDue = true;
//                    this.arrearsIndex = 109;
//                }
                break;
        }
    }
}


