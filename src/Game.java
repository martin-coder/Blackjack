import java.util.Scanner;
// TODO implement score system
public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("-------------");
        System.out.println("--BLACKJACK--");
        System.out.println("-------------");
        System.out.println();

        Table table = new Table();

        boolean continuePlaying;

        do {
            table.deck().shuffle();

            initDeal(table);


            if (!(table.dealer().handValue() > 20 || table.player().handValue() > 20)) {
                int intent;
                do {
                    printCurrentState(table, true);
                    System.out.println();
                    do {
                        intent = getPlayerIntent(scanner);
                    } while (intent == -1);

                    if (intent == 0) {
                        table.player().hand().addCard(table.deck().removeCard());
                    }
                } while (table.player().handValue() < 21 && intent != 1);
            }

            String winner = calcWinner(table.dealer(), table.player()).name();

            printWinner(table, winner); // Prints winner and final hands

            continuePlaying = checkContinue(scanner);

            if (continuePlaying) resetGame(table);


        } while (continuePlaying);
    }

    private static void resetGame(Table table) {
        table.deck().addAll(table.dealer().hand());
        table.deck().addAll(table.player().hand());
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

    private static void printCurrentState(Table table, boolean hidden) {
        if (hidden) {
            System.out.println("DEALER: " + table.dealer().hand().toString(true));
        } else {
            System.out.println("DEALER: " + table.dealer().hand().toString(false));
            System.out.println("  DEALER TOTAL: " + table.dealer().handValue());
        }
        System.out.println("PLAYER: " + table.player().hand().toString(false));
        System.out.println("  PLAYER TOTAL: " + table.player().handValue());
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


    //TODO clean up calculation logic
    private static Player calcWinner(Dealer dealer, Player player) {

        if (player.handValue() > 21) {
            return dealer;
        }
        if (dealer.handValue() > 21) {
            return player;
        }
        if (dealer.handValue() == 21 ) {
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

    private static void printWinner(Table table, String winner) {
        System.out.println();
        printCurrentState(table, false);
        System.out.println();
        System.out.println("---Winner is " + winner.toUpperCase() + "---");
        System.out.println();
    }

    private static boolean checkContinue(Scanner scanner) {
        // Check if player wishes to play again
        System.out.println("Play again? (Y/N)");

        if (scanner.next().toLowerCase().equals("y")) {
            return true;
        } else {
            System.out.println("Goodbye!");
            return false;
        }
    }
}
