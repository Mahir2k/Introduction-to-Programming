import java.util.Scanner;
import java.util.Random;

public class HandGenerator {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        // This string will help us decide if the user wants to play again
        String playAgain = "y";

        // This loop keeps the game going as long as the user wants to play
        while (playAgain.equalsIgnoreCase("y")) {
            // Asking the user how they want to get their cards
            System.out.println("Choose card selection type:");
            System.out.println("1. Random cards");
            System.out.println("2. Input cards manually");
            System.out.print("Enter 1 or 2: ");
            int choice = myScanner.nextInt();

            // These variables will store our card numbers
            int card1 = -1, card2 = -1, card3 = -1, card4 = -1, card5 = -1;

            if (choice == 1) {
                // If the user chose random cards, we use Random to generate them
                Random random = new Random();
                card1 = random.nextInt(52);
                // These loops make sure we don't get any duplicate cards
                while (card2 == -1 || card2 == card1) card2 = random.nextInt(52);
                while (card3 == -1 || card3 == card1 || card3 == card2) card3 = random.nextInt(52);
                while (card4 == -1 || card4 == card1 || card4 == card2 || card4 == card3) card4 = random.nextInt(52);
                while (card5 == -1 || card5 == card1 || card5 == card2 || card5 == card3 || card5 == card4) card5 = random.nextInt(52);

                // Showing the user their random cards
                System.out.println("Your random cards are: " + card1 + ", " + card2 + ", " + card3 + ", " + card4 + ", " + card5);
            } else if (choice == 2) {
                // If the user wants to input cards manually, we use this loop
                boolean validInput = false;
                while (!validInput) {
                    System.out.println("Enter 5 cards (numbers 0 to 51), don't choose the same number: ");
                    card1 = myScanner.nextInt();
                    card2 = myScanner.nextInt();
                    card3 = myScanner.nextInt();
                    card4 = myScanner.nextInt();
                    card5 = myScanner.nextInt();

                    // This big if-statement checks if the input is valid (no duplicates, within range)
                    if (card1 < 0 || card2 < 0 || card3 < 0 || card4 < 0 || card5 < 0 || 
                        card1 > 51 || card2 > 51 || card3 > 51 || card4 > 51 || card5 > 51 ||
                        card1 == card2 || card1 == card3 || card1 == card4 || card1 == card5 ||
                        card2 == card3 || card2 == card4 || card2 == card5 ||
                        card3 == card4 || card3 == card5 || card4 == card5) {
                        System.out.println("Invalid or duplicate cards. Please try again.");
                    } else {
                        validInput = true;
                    }
                }
            } else {
                // If the user didn't choose 1 or 2, we tell them it's invalid and start over
                System.out.println("Invalid selection.");
                continue;
            }

            // Now we figure out what kind of hand the user has
            String result = scoreHand(card1, card2, card3, card4, card5);
            System.out.println("Result: " + result);

            // Asking if the user wants to play again
            System.out.print("Would you like to play again? (y/n): ");
            playAgain = myScanner.next();
        }

        
        
    }

    // This method figures out the best hand the user has
    public static String scoreHand(int card1, int card2, int card3, int card4, int card5) {
        if (flushTest(card1, card2, card3, card4, card5)) {
            return "Flush";
        } else if (threeOfAKindTest(card1, card2, card3, card4, card5)) {
            return "Three of a Kind";
        } else if (twoPairTest(card1, card2, card3, card4, card5)) {
            return "Two Pair";
        } else if (pairTest(card1, card2, card3, card4, card5)) {
            return "One Pair";
        } else {
            return "High Card: " + findHighCard(card1, card2, card3, card4, card5);
        }
    }

    // This checks if all cards are the same suit
    public static boolean flushTest(int card1, int card2, int card3, int card4, int card5) {
        return (card1 / 13 == card2 / 13) && (card2 / 13 == card3 / 13) && (card3 / 13 == card4 / 13) && (card4 / 13 == card5 / 13);
    }

    // This checks if there are three cards of the same value
    public static boolean threeOfAKindTest(int card1, int card2, int card3, int card4, int card5) {
        return (card1 % 13 == card2 % 13 && card2 % 13 == card3 % 13) ||
               (card1 % 13 == card3 % 13 && card3 % 13 == card4 % 13) ||
               (card1 % 13 == card4 % 13 && card4 % 13 == card5 % 13) ||
               (card2 % 13 == card3 % 13 && card3 % 13 == card5 % 13);
    }

    // This checks if there are two pairs
    public static boolean twoPairTest(int card1, int card2, int card3, int card4, int card5) {
        int a = card1 % 13, b = card2 % 13, c = card3 % 13, d = card4 % 13, e = card5 % 13;
        return ((a == b && c == d) || (a == b && d == e) || (a == c && d == e) ||
                (b == c && d == e) || (a == d && b == e) || (a == e && b == c));
    }

    // This checks if there's at least one pair
    public static boolean pairTest(int card1, int card2, int card3, int card4, int card5) {
        int a = card1 % 13, b = card2 % 13, c = card3 % 13, d = card4 % 13, e = card5 % 13;
        return (a == b || a == c || a == d || a == e || b == c || b == d || b == e || c == d || c == e || d == e);
    }

    // This finds the highest card in the hand
    // Used array in this method to see how array works
    public static int findHighCard(int card1, int card2, int card3, int card4, int card5) {
        int[] cards = {card1 % 13, card2 % 13, card3 % 13, card4 % 13, card5 % 13};
        int highCard = cards[0];
        
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] > highCard) {
                highCard = cards[i];
            }
        }
        
        return highCard;
    }
}