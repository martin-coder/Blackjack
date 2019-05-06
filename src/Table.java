class Table {

    private Deck deck;
    private int numPlayers;
    Dealer dealer;
    private Player[] players;

    Table(int numPlayers) {
        deck = new Deck(false);
        this.numPlayers = numPlayers;
        dealer = new Dealer();
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            players[i].setName("Player " + i);
        }
    }

    Deck deck() {
        return deck;
    }

    Player getPlayer(int n) {
        return players[n-1];
    }

    Dealer dealer() {
        return dealer;
    }

    int getNumPlayers() {
        return numPlayers;
    }
}
