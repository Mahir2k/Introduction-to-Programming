public class SpadeCard extends SuitedCard {

    // Constructor
    public SpadeCard(int rankInput, int serialInput) {
        //Calling the parent class constructor
        super(rankInput, serialInput);

        //Ensureing rank range
        if (rankInput < 39 || rankInput > 51) {
            System.out.println("Error: Invalid rank for Spades.");
            rank = -1; //invalid rank
            serial = -1; //invalid serial
        }
    }

    @Override
    public void printSuit() {
        System.out.println("of Spades");
    }

    @Override
    public int suit() {
        return 3;
    }
}