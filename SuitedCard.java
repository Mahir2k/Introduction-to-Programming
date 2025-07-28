public class SuitedCard {
    // Rank of the card (0-51).
    protected int rank;

    //Identifier
    protected int serial;

    //Constructor
    public SuitedCard(int rankInput, int serialInput) {
        rank = rankInput;
        serial = serialInput;
    }

    public void printSuit() {
        System.out.println("Not a suited card!");
    }

    public int suit() {
        return -1;
    }

    //rank of the card
    public String card() {
        int cardRank = rank % 13;
        switch (cardRank) {
            case 0:
                return "ace";
            case 10:
                return "jack";
            case 11:
                return "queen";
            case 12:
                return "king";
            default:
                return String.valueOf(cardRank + 1);
        }
    }
}


