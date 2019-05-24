import java.util.ArrayList;
import java.util.Random;

class Deck {

    public class Card {

        private int value;
        private int suit;

        private String[] values = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        private String[] suits = {null, "Hearts", "Diamonds", "Clubs", "Spades"};

        private Card(int value, int suit) {
            this.value = value;
            this.suit = suit;
        }

        public String toString() {
            return values[this.value] + " of " + suits[this.suit];
        }
    }

    private ArrayList<Card> deck;
    private int numCards;

    Deck(boolean empty) {
        this.numCards = 0;
        this.deck = new ArrayList<>(52);   //  All decks have max capacity of 52, so there is no need to mess around with resizing

        if (!empty) {
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 14; j++) {
                    Card card = new Card(j, i);
                    deck.add(card);
                }
            }
        }
    }

    Deck(ArrayList<Card> cards) {
        this.numCards = 0;
        this.deck = new ArrayList<>(52);

        deck.addAll(cards);
    }

    int getNumCards() {
        return numCards;
    }

    int getTotalValue() {
        int totalValue = 0;
        for (Card card : deck) {
            if (card.value == 11 || card.value == 12 || card.value == 13) {     //  All face cards have a point value of 10
                totalValue +=  10;
            } else {
                totalValue += card.value;
            }
        }
        return totalValue;
    }

    void addCard(Card card) {
        deck.add(card);
        numCards++;
    }

    void addAll(Deck deck) {

        while (!deck.isEmpty()) {
            this.addCard(deck.removeCard());
        }
    }

    Card removeCard() {
        Card removed = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        numCards--;
        return removed;
    }

    void shuffle() {
        Random r = new Random();

        for (int i = 0; i < deck.size(); i++) {
            Card a = deck.get(i);

            int rand = r.nextInt(deck.size());
            Card b = deck.get(rand);

            deck.set(rand, a);
            deck.set(i, b);
        }
    }

    boolean contains(int value) {

        boolean hasAce = false;

        for (Card card : deck) {
            if (card.value == value) {
                hasAce = true;
                break;
            }
        }
        return hasAce;
    }

    private boolean isEmpty() {
        return numCards == 0;
    }

    String toString(Boolean hideFirst) {
        if (hideFirst) {
            String str = deck.toString();
            return "[** of *****" + str.substring(str.indexOf(','));
        }
        return deck.toString();
    }



}
