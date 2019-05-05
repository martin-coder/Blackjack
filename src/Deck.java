import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private class Card {

        private int value;
        private String suit;

        private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        private Card(int value, int suit) {
            this.value = value;
            this.suit = suits[suit];
        }

        public String toString() {
            return this.value + this.suit;
        }
    }

    private ArrayList<Card> deck;
    private int numCards;

    public Deck() {
        this.numCards = 0;
        this.deck = new ArrayList<>(52);   //  All decks have max capacity of 52, so there is no need to mess around with resizing

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                Card card = new Card(j, i);
                deck.add(card);
                numCards++;
            }
        }
    }

    public Deck(ArrayList<Card> cards) {
        this.numCards = 0;
        this.deck = new ArrayList<>(52);

        deck.addAll(cards);
    }

    public void addCard(Card card) {
        deck.add(card);
        numCards++;
    }

    public Card removeCard() {
        return deck.remove(deck.size()-1);
    }

    public void shuffle() {
        Random r = new Random();

        for (int i = 0; i < deck.size(); i++) {
            Card a = deck.get(i);

            int rand = r.nextInt(deck.size());
            Card b = deck.get(rand);

            deck.set(rand, a);
            deck.set(i, b);
        }
    }

    public String toString() {
        return deck.toString();
    }
}
