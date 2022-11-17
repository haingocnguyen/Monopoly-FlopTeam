import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



public class DeckOfChanceAndFortuneCards {
    private ArrayList<ChanceCard> chanceCards = new ArrayList();
    private ArrayList<ChanceCard> dealtChanceCards = new ArrayList();
    private ChanceCard getOutOfJailChance;
    private ArrayList<FortuneCard> communityCards = new ArrayList();
    private ArrayList<FortuneCard> dealtFortuneCards = new ArrayList();
    private FortuneCard getOutOfJailCommunity;
    private Random random = new Random();

    public DeckOfChanceAndFortuneCards() {
        this.chanceCards.add(new ChanceCard(0));
        this.chanceCards.add(new ChanceCard(1));
        this.chanceCards.add(new ChanceCard(2));
        this.chanceCards.add(new ChanceCard(3));
        this.chanceCards.add(new ChanceCard(4));
        this.chanceCards.add(new ChanceCard(5));
        this.chanceCards.add(new ChanceCard(6));
        this.chanceCards.add(new ChanceCard(7));
        this.chanceCards.add(new ChanceCard(8));
        this.chanceCards.add(new ChanceCard(9));
        this.chanceCards.add(new ChanceCard(10));
        this.chanceCards.add(new ChanceCard(11));
        this.chanceCards.add(new ChanceCard(12));
        this.chanceCards.add(new ChanceCard(13));
        this.chanceCards.add(new ChanceCard(14));
        this.chanceCards.add(new ChanceCard(15));
        this.communityCards.add(new FortuneCard(0));
        this.communityCards.add(new FortuneCard(1));
        this.communityCards.add(new FortuneCard(2));
        this.communityCards.add(new FortuneCard(3));
        this.communityCards.add(new FortuneCard(4));
        this.communityCards.add(new FortuneCard(5));
        this.communityCards.add(new FortuneCard(6));
        this.communityCards.add(new FortuneCard(7));
        this.communityCards.add(new FortuneCard(8));
        this.communityCards.add(new FortuneCard(9));
        this.communityCards.add(new FortuneCard(10));
        this.communityCards.add(new FortuneCard(11));
        this.communityCards.add(new FortuneCard(12));
        this.communityCards.add(new FortuneCard(13));
        this.communityCards.add(new FortuneCard(14));
        this.communityCards.add(new FortuneCard(15));
        this.communityCards.add(new FortuneCard(16));
    }

    public int dealChanceCard() {
        if (this.chanceCards.size() == 0) {
            this.chanceCards = this.dealtChanceCards;
            this.dealtChanceCards = new ArrayList();
        }

        int position = this.random.nextInt(this.chanceCards.size());
        int id = ((ChanceCard)this.chanceCards.get(position)).getId();
        if (id == 6) {
            this.setGetOutOfJailChance((ChanceCard)this.chanceCards.get(position));
        } else {
            this.dealtChanceCards.add((ChanceCard)this.chanceCards.get(position));
        }

        this.chanceCards.remove(position);
        return id;
    }

    public int dealFortuneCard() {
        if (this.communityCards.size() == 0) {
            this.communityCards = this.dealtFortuneCards;
            this.dealtFortuneCards = new ArrayList();
        }

        int position = this.random.nextInt(this.communityCards.size());
        int id = ((FortuneCard)this.communityCards.get(position)).getId();
        if (id == 3) {
            this.setGetOutOfJailCommunity((FortuneCard)this.communityCards.get(position));
        } else {
            this.dealtFortuneCards.add((FortuneCard)this.communityCards.get(position));
        }

        this.communityCards.remove(position);
        return id;
    }

    public void returnOutOfJailCardChance() {
        this.dealtChanceCards.add(this.getOutOfJailChance);
        this.setGetOutOfJailChance((ChanceCard)null);
    }

    public ChanceCard getGetOutOfJailChance() {
        return this.getOutOfJailChance;
    }

    public void setGetOutOfJailChance(ChanceCard getOutOfJailChance) {
        this.getOutOfJailChance = getOutOfJailChance;
    }

    public ChanceCard getChanceCard(int id) {
        Iterator var3 = this.chanceCards.iterator();

        while(var3.hasNext()) {
            ChanceCard card = (ChanceCard)var3.next();
            if (card.getId() == id) {
                return card;
            }
        }

        return null;
    }

    public void returnOutOfJailCardCommunity() {
        this.dealtFortuneCards.add(this.getOutOfJailCommunity);
        this.setGetOutOfJailCommunity((FortuneCard)null);
    }

    public FortuneCard getGetOutOfJailCommunity() {
        return this.getOutOfJailCommunity;
    }

    public void setGetOutOfJailCommunity(FortuneCard getOutOfJailCommunity) {
        this.getOutOfJailCommunity = getOutOfJailCommunity;
    }

    public FortuneCard getCommunityCard(int id) {
        Iterator var3 = this.communityCards.iterator();

        while(var3.hasNext()) {
            FortuneCard card = (FortuneCard)var3.next();
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }



}
