class Player {

    private Deck hand;
    private int handValue;
    private String name;

    Player() {
        hand = new Deck(true);
        handValue = hand.getTotalValue();
        name = "Player 1";
    }

    Deck hand() {
        return hand;
    }

    String name() {
        return name;
    }

    void setName(String name) { this.name = name; }

    int handValue() {
        return handValue;
    }
}
