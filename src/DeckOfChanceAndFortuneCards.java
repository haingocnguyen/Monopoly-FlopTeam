import java.util.ArrayList;
import java.util.Random;

public class DeckOfChanceAndFortuneCards {
    private final Random random = new Random();
    private ArrayList<ChanceCard> chanceCards = new ArrayList<>();
    private ArrayList<ChanceCard> dealtChanceCards = new ArrayList<>();
    private ChanceCard getOutOfJailChance;
    private ArrayList<FortuneCard> fortuneCards = new ArrayList<>();
    private ArrayList<FortuneCard> dealtFortuneCards = new ArrayList<>();
    private FortuneCard getOutOfJailCommunity;

    public DeckOfChanceAndFortuneCards() {
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
        this.chanceCards.add(new ChanceCard(16));
        this.chanceCards.add(new ChanceCard(17));
        this.chanceCards.add(new ChanceCard(18));
        this.chanceCards.add(new ChanceCard(19));
        this.chanceCards.add(new ChanceCard(20));

        this.fortuneCards.add(new FortuneCard(1));
        this.fortuneCards.add(new FortuneCard(2));
        this.fortuneCards.add(new FortuneCard(3));
        this.fortuneCards.add(new FortuneCard(4));
        this.fortuneCards.add(new FortuneCard(5));
        this.fortuneCards.add(new FortuneCard(6));
        this.fortuneCards.add(new FortuneCard(7));
        this.fortuneCards.add(new FortuneCard(8));
        this.fortuneCards.add(new FortuneCard(9));
        this.fortuneCards.add(new FortuneCard(10));
        this.fortuneCards.add(new FortuneCard(11));
        this.fortuneCards.add(new FortuneCard(12));
        this.fortuneCards.add(new FortuneCard(13));
        this.fortuneCards.add(new FortuneCard(14));
        this.fortuneCards.add(new FortuneCard(15));
        this.fortuneCards.add(new FortuneCard(16));
        this.fortuneCards.add(new FortuneCard(17));
        this.fortuneCards.add(new FortuneCard(18));
        this.fortuneCards.add(new FortuneCard(19));
        this.fortuneCards.add(new FortuneCard(20));
    }

    public int dealChanceCard() {
        if (this.chanceCards.size() == 0) {
            this.chanceCards = this.dealtChanceCards;
            this.dealtChanceCards = new ArrayList<>();
        }

        int position = this.random.nextInt(this.chanceCards.size());
        int id = this.chanceCards.get(position).getId();
        if (id == 7) {
            this.setGetOutOfJailChance(this.chanceCards.get(position));
        } else {
            this.dealtChanceCards.add(this.chanceCards.get(position));
        }

        this.chanceCards.remove(position);
        return id;
    }

    public int dealFortuneCard() {
        if (this.fortuneCards.size() == 0) {
            this.fortuneCards = this.dealtFortuneCards;
            this.dealtFortuneCards = new ArrayList<>();
        }

        int position = this.random.nextInt(this.fortuneCards.size());
        int id = this.fortuneCards.get(position).getId();
        if (id == 14) {
            this.setGetOutOfJailCommunity(this.fortuneCards.get(position));
        } else {
            this.dealtFortuneCards.add(this.fortuneCards.get(position));
        }

        this.fortuneCards.remove(position);
        return id;
    }

    public void returnOutOfJailCardChance() {
        this.dealtChanceCards.add(this.getOutOfJailChance);
        this.setGetOutOfJailChance(null);
    }

    public void setGetOutOfJailChance(ChanceCard getOutOfJailChance) {
        this.getOutOfJailChance = getOutOfJailChance;
    }

    public void returnOutOfJailCardCommunity() {
        this.dealtFortuneCards.add(this.getOutOfJailCommunity);
        this.setGetOutOfJailCommunity(null);
    }

    public void setGetOutOfJailCommunity(FortuneCard getOutOfJailCommunity) {
        this.getOutOfJailCommunity = getOutOfJailCommunity;
    }

    public FortuneCard getFortuneCard(int id) {

        for (FortuneCard card : this.fortuneCards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }
}

