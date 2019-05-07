import java.util.Scanner;

public class Game {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--BLACKJACK--");

        Table table = new Table();

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


    }

    private static void initDeal(Table table) {

        for (int j = 0; j < 2; j++) {
            table.dealer().hand().addCard(table.deck().removeCard());
            table.player().hand().addCard(table.deck().removeCard());
        }
    }

    private static void printCurrentState(Table table) {
        System.out.println("DEALER: " + table.dealer().hand().toString());
        System.out.println("  TOTAL: " + table.dealer().handValue());
        System.out.println("PLAYER: " + table.player().hand().toString());
        System.out.println("  TOTAL: " + table.player().handValue());
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
