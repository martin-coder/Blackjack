import java.util.Scanner;

public class Game {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--BLACKJACK--");

        Table table = new Table();

        //TODO Put everything in a game loop

        for (int i = 0; i < 10; i++) {               //  Get it real nice n shuffled (shuffling algorithm is pretty terrible so doing it 10x helps)
            table.deck().shuffle();
        }

        initDeal(table);
        printCurrentState(table);

        //TODO if initial deal is 21 for player or dealer, they must immediately win
        //TODO if dealer's hand is >= 21, player must immediately win

        System.out.println();

        int intent;
        do {
            do {
                intent = getPlayerIntent(scanner);
            } while (intent == -1);

            if (intent == 0) {
                table.player().hand().addCard(table.deck().removeCard());
            }
        } while (table.player().handValue() < 21 && intent != 1);

        String winner = calcWinner(table.dealer(), table.player()).name();
        System.out.println("Winner is " + winner);
    }

    private static void initDeal(Table table) {

        for (int j = 0; j < 2; j++) {
            table.dealer().hand().addCard(table.deck().removeCard());
            table.player().hand().addCard(table.deck().removeCard());
        }

        while (table.dealer().handValue() < 17) {
            table.dealer().hand().addCard(table.deck().removeCard());
        }
    }

    private static void printCurrentState(Table table) {
        System.out.println("DEALER: " + table.dealer().hand().toString());
        System.out.println("  TOTAL: " + table.dealer().handValue());
        System.out.println("PLAYER: " + table.player().hand().toString());
        System.out.println("  TOTAL: " + table.player().handValue());
    }

    private static int getPlayerIntent(Scanner scanner) {
        System.out.println("Hit or Stand?");
        String move = scanner.next().toLowerCase();
        if (move.equals("hit")) {
            return 0;
        } else if (move.equals("stand")) {
            return 1;
        } else {
            return -1;
        }
    }

    private static Player calcWinner(Dealer dealer, Player player) {
        if (player.handValue() > 20) {
            return dealer;
        }
        if (player.handValue() == 21) {
            return player;
        }

        if (player.handValue() > dealer.handValue()) {
            return player;
        } else {
            return dealer;
        }
    }

    //TODO Create & implement getValue() method
}
