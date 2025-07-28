public class ClubCard extends SuitedCard {

    //Constructor
    public ClubCard(int rankInput, int serialInput) {
        // Calls the parent class constructor
        super(rankInput, serialInput);

        //ensuring rank range
        if (rankInput < 13 || rankInput > 25) {
            System.out.println("Error: Invalid rank for Clubs.");
            rank = -1; //invalid rank
            serial = -1; //invalid serial
        }
    }

    @Override
    public void printSuit() {
        System.out.println("of Clubs");
    }

    @Override
    public int suit() {
        return 1;
    }
}