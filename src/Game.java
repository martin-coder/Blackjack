import java.util.Scanner;

public class Game {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--BLACKJACK--");
        System.out.print("How many players? ");
        int numPlayers = scanner.nextInt();

        Table table = new Table(numPlayers);
        int currentPlayer = 1;

        for (int i = 0; i < 10; i++) {               //  Get it real nice n shuffled (shuffling algorithm is pretty terrible so doing it 10x helps)
            table.deck().shuffle();
        }

        initDeal(table);
        printCurrentState(table);

        System.out.println();

        int intent;
        do {
            intent = getPlayerIntention(scanner);
        } while (intent == -1);

        if (intent == 1) {
            if (currentPlayer < table.getNumPlayers()) {
                currentPlayer += 1;
            } else {
                currentPlayer = 1;
            }

        }


    }

    private static void initDeal(Table table) {
        for (int i = 1; i <= table.getNumPlayers(); i++) {
            for (int j = 0; j < 2; j++) {
                table.dealer.hand().addCard(table.deck().removeCard());
                table.getPlayer(i).hand().addCard(table.deck().removeCard());
            }
        }
    }

    private static void printCurrentState(Table table) {
        System.out.println("DEALER: " + table.dealer.hand().toString());
        System.out.println("  TOTAL: " + table.dealer.handValue());
        System.out.println("PLAYER " + table.getPlayer(1).hand().toString());
        System.out.println("  TOTAL: " + table.getPlayer(1).handValue());
    }

    private static int getPlayerIntention(Scanner scanner) {
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
}
