public class Tester {
    public static void main(String[] args) {
        Deck deck = new Deck(false);

        System.out.println(deck);
        System.out.println(deck.getNumCards());

        Deck hand = new Deck(true);
        Deck hand2 = new Deck(true);
        for (int i = 0; i<3; i++) {
            hand.addCard(deck.removeCard());
            hand2.addCard(deck.removeCard());
        }
        printStatus(hand, hand2);
        System.out.println();

//        System.out.println(deck);
//        System.out.println(deck.getNumCards());

        hand2.addAll(hand);
        printStatus(hand, hand2);





//        deck.removeCard();
//        System.out.println(deck);
//        System.out.println(deck.getNumCards());

        //deck.shuffle();
        //System.out.println(deck);


    }
    private static void printStatus(Deck hand, Deck hand2) {

        System.out.println("HAND: " + hand.toString());
        System.out.println("numCards: " + hand.getNumCards());
        System.out.println("HAND2: " + hand2.toString());
        System.out.println("numCards: " + hand2.getNumCards());
    }
}
