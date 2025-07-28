import java.util.Random;

public class Straight {

    // Method to generate a shuffled deck of cards
    public static int[] generateShuffledDeck() {
        int[] deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }

        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap deck[i] with deck[j]
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        return deck;
    }

    // Method to generate a 5-card hand from the shuffled deck
    public static int[] generateHand(int[] deck) {
        int[] hand = new int[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }

    // Method to find the kth lowest card in a hand
    public static int findKthLowest(int[] hand, int k) {
        if (k <= 0 || k > hand.length) {
            System.out.println("Error: k must be between 1 and 5");
            return -1; // Return an invalid value to indicate an error
        }

        // Create a sorted version of the hand using a simple sort
        int[] sortedHand = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            sortedHand[i] = hand[i];
        }

        for (int i = 0; i < sortedHand.length - 1; i++) {
            for (int j = i + 1; j < sortedHand.length; j++) {
                if (sortedHand[i] > sortedHand[j]) {
                    int temp = sortedHand[i];
                    sortedHand[i] = sortedHand[j];
                    sortedHand[j] = temp;
                }
            }
        }

        return sortedHand[k - 1];
    }

    // Method to test if a hand contains a straight
    public static boolean isStraight(int[] hand) {
        int lowestCard = findKthLowest(hand, 1) % 13; // Find the rank of the lowest card (0-12)
        if (lowestCard == -1) {
            return false; // Invalid k detected
        }

        for (int i = 1; i < 5; i++) {
            int nextCard = lowestCard + i;

            boolean found = false;
            for (int card : hand) {
                if (card % 13 == nextCard) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false; // If the next card in sequence is not found, not a straight
            }
        }

        return true;
    }

    // Main method to test for straight hands
    public static void main(String[] args) {
        int totalHands = 1_000_000; // Test on one million hands
        int straightCount = 0;

        for (int i = 0; i < totalHands; i++) {
            int[] deck = generateShuffledDeck();
            int[] hand = generateHand(deck);

            if (isStraight(hand)) {
                straightCount++;
            }
        }

        double straightProbability = (double) straightCount / totalHands * 100;
        System.out.printf("Out of %d hands, %d were straights.%n", totalHands, straightCount);
        System.out.printf("Observed probability of straight: %.4f%%%n", straightProbability);
        System.out.println("Expected probability of straight: 0.3925%");
    }
}
