public class DiamondCard extends SuitedCard {

    //constructor
    public DiamondCard(int rankInput, int serialInput) {
        //Calling the parent class constructor
        super(rankInput, serialInput);

        //ensuring rank range
        if (rankInput < 0 || rankInput > 12) {
            System.out.println("Error: Invalid rank for Diamonds.");
            rank = -1; //invalid rank
            serial = -1; //invalid serial
        }
    }

    @Override
    public void printSuit() {
        System.out.println("of Diamonds");
    }

    @Override
    public int suit() {
        return 0;
    }
}
