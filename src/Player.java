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
        return hand.getTotalValue();

    }
}
