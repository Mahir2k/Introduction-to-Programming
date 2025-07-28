// Mahir Ashab Enan
// Homework 03

public class SimpleYahtzee {
    public static void main(String[] args) {
        // Number of dice and sides on the dice
        int dice_num = 5;
        int dice_side = 6;
        
        // Rolling the five dice and generating random numbers between 1 and 6
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        int dice3 = (int) (Math.random() * 6 + 1);
        int dice4 = (int) (Math.random() * 6 + 1);
        int dice5 = (int) (Math.random() * 6 + 1);

        // Counters to keep track of the number of each face value (1 to 6)
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        
        // Counting how many times each dice value (1-6) appears
        switch(dice1) {
            case 1: ones++; break;
            case 2: twos++; break;
            case 3: threes++; break;
            case 4: fours++; break;
            case 5: fives++; break;
            case 6: sixes++; break;
        }
        switch(dice2) {
            case 1: ones++; break; 
            case 2: twos++; break; 
            case 3: threes++; break;
            case 4: fours++; break;
            case 5: fives++; break;
            case 6: sixes++; break;
        }
        switch(dice3) {
            case 1: ones++; break; 
            case 2: twos++; break; 
            case 3: threes++; break;
            case 4: fours++; break;
            case 5: fives++; break;
            case 6: sixes++; break;
        }
        switch(dice4) {
            case 1: ones++; break; 
            case 2: twos++; break; 
            case 3: threes++; break;
            case 4: fours++; break;
            case 5: fives++; break;
            case 6: sixes++; break;
        }
        switch(dice5) {
            case 1: ones++; break; 
            case 2: twos++; break; 
            case 3: threes++; break;
            case 4: fours++; break;
            case 5: fives++; break;
            case 6: sixes++; break;
        }

        // First Half: Displaying the counts and scores for each face value
        System.out.println("First Half:");
        System.out.println("counts:");
        System.out.println("ones: " + ones);
        System.out.println("twos: " + twos);
        System.out.println("threes: " + threes);
        System.out.println("fours: " + fours);
        System.out.println("fives: " + fives);
        System.out.println("sixes: " + sixes);

        // Displaying the score for each face value
        System.out.println("scores:");
        System.out.println("ones: " + (ones * 1));
        System.out.println("twos: " + (twos * 2));
        System.out.println("threes: " + (threes * 3));
        System.out.println("fours: " + (fours * 4));
        System.out.println("fives: " + (fives * 5));
        System.out.println("sixes: " + (sixes * 6));

        // Second Half: Checking for special patterns like three of a kind, full house, or straight
        System.out.println("Second Half:");

        // Checking if there is a three of a kind (three dice with the same value)
        boolean threeOfAKind = (ones >= 3 || twos >= 3 || threes >= 3 || fours >= 3 || fives >= 3 || sixes >= 3);
        if (threeOfAKind) {
            // Sum of all dice values for the score
            int score = dice1 + dice2 + dice3 + dice4 + dice5;
            System.out.println("*three of a kind: 1");
            System.out.println("score: " + (score * 10));
        } else {
            System.out.println("*three of a kind: 0");
            System.out.println("score: 0");
        }

        // Checking if there is a full house (three of one value and two of another)
        boolean fullHouse = ((ones == 3 || twos == 3 || threes == 3 || fours == 3 || fives == 3 || sixes == 3) &&
                            (ones == 2 || twos == 2 || threes == 2 || fours == 2 || fives == 2 || sixes == 2));
        if (fullHouse) {
            // Sum of all dice values for the score
            int score = dice1 + dice2 + dice3 + dice4 + dice5;
            System.out.println("*full house: 1");
            System.out.println("score: " + (score * 100));
        } else {
            System.out.println("*full house: 0");
            System.out.println("score: 0");
        }

        // Checking if there is a straight (consecutive values: 1-5 or 2-6)
        boolean straight = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1 && fives >= 1) ||
                           (twos >= 1 && threes >= 1 && fours >= 1 && fives >= 1 && sixes >= 1);
        if (straight) {
            // Sum of all dice values for the score
            int score = dice1 + dice2 + dice3 + dice4 + dice5;
            System.out.println("*straights: 1");
            System.out.println("score: " + (score * 1000));
        } else {
            System.out.println("*straights: 0");
            System.out.println("score: 0");
        }

        // Displaying the values of each rolled die
        System.out.println("Roll of Dice 1 = " + dice1);
        System.out.println("Roll of Dice 2 = " + dice2);
        System.out.println("Roll of Dice 3 = " + dice3);
        System.out.println("Roll of Dice 4 = " + dice4);
        System.out.println("Roll of Dice 5 = " + dice5);
    }
}
    