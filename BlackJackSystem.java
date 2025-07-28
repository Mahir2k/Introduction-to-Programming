import java.util.Scanner;
import java.util.Random;

public class BlackJackSystem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Decknum;

        // Input of the number of decks from the user
        while (true) {
            System.out.print("Enter the number of decks you want to play with: ");
            if (s.hasNextInt()) {
                Decknum = s.nextInt();
                if (Decknum > 0) break;
            } else {
                s.next();
            }
            System.out.println("Please enter a positive integer.");
        }

        int totalCards = Decknum * 52;
        SuitedCard[] Decks = new SuitedCard[totalCards];
        int[] ranks = new int[totalCards];

        //Filling ranks array
        for (int i = 0; i < totalCards; i++) {
            ranks[i] = i % 52;
        }

        //Populating the Decks array
        for (int i = 0; i < totalCards; i++) {
            int rank = ranks[i];
            int serial = i + 1;

            if (rank >= 0 && rank <= 12) {
                Decks[i] = new DiamondCard(rank, serial);
            } else if (rank >= 13 && rank <= 25) {
                Decks[i] = new ClubCard(rank, serial);
            } else if (rank >= 26 && rank <= 38) {
                Decks[i] = new HeartCard(rank, serial);
            } else if (rank >= 39 && rank <= 51) {
                Decks[i] = new SpadeCard(rank, serial);
            }
        }

        //Shuffling the cards
        Random random = new Random();
        for (int i = 0; i < totalCards; i++) {
            int randomIndex = random.nextInt(totalCards);
            SuitedCard temp = Decks[i];
            Decks[i] = Decks[randomIndex];
            Decks[randomIndex] = temp;
        }

        //Give two cards to the player by dealing
        System.out.print("Player's first card: ");
        Decks[0].printSuit();
        System.out.println(Decks[0].card());

        System.out.print("Player's second card: ");
        Decks[1].printSuit();
        System.out.println(Decks[1].card());

        s.close();
    }
}

