public class HeartCard extends SuitedCard {

    //Constructor
    public HeartCard(int rankInput, int serialInput) {
        //calling the parent class constructor
        super(rankInput, serialInput);

        //Ensuring rank range
        if (rankInput < 26 || rankInput > 38) {
            System.out.println("Error: Invalid rank for Hearts.");
            rank = -1; //invalid rank
            serial = -1; //invalid serial
        }
    }

    @Override
    public void printSuit() {
        System.out.println("of Hearts");
    }

    @Override
    public int suit() {
        return 2;
    }
}