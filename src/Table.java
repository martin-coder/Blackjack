class Table {

    private Deck deck;
    private Dealer dealer;
    private Player player;

    Table() {
        deck = new Deck(false);
        dealer = new Dealer();
        player = new Player();
        }

    Deck deck() {
        return deck;
    }

    Player player() {
        return player;
    }

    Dealer dealer() {
        return dealer;
    }
}
