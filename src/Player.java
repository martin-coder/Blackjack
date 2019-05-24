class Player {

    private Deck hand;
    private String name;

    Player() {
        hand = new Deck(true);
        name = "Player";
    }

    Deck hand() {
        return hand;
    }

    String name() {
        return name;
    }

    void setName(String name) { this.name = name; }

    int handValue() {

        int handValue = hand.getTotalValue();

        if (handValue < 12 && hand.contains(1)) {
            return handValue + 10;
        } else {
            return handValue;
        }

    }
}
