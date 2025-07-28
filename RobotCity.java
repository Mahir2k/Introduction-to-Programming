import java.util.Random;

public class RobotCity {

    // Method to initialize the city with random population
    public static void buildCity(int[][] cityArray) {
        Random randomGenerator = new Random(); // Random object to generate random values
        int rows = cityArray.length;           // Number of rows in the city
        int cols = cityArray[0].length;        // Number of columns in the city
        
        // Filling each cell of the city with a random population between 100 and 999
        for (int[] row : cityArray) {
            for (int j = 0; j < cols; j++) {
                row[j] = randomGenerator.nextInt(900) + 100; // Random population
            }
        }
    }

    // Method to simulate a robot invasion in the city
    public static void invade(int[][] cityArray) {
        Random randomGenerator = new Random(); 
        int numRobots = randomGenerator.nextInt(11) + 5; // Random number of robots between 5 and 15
        
        int rows = cityArray.length; 
        int cols = cityArray[0].length;
        int robotsPlaced = 0;

        // Placing robots until the required number is met
        while (robotsPlaced < numRobots) {
            int r = randomGenerator.nextInt(rows);  // Random row index
            int c = randomGenerator.nextInt(cols);  // Random column index

            // Placing a robot only in cells with a positive population
            if (cityArray[r][c] > 0) {
                cityArray[r][c] = -cityArray[r][c]; // Robots are represented as negative values
                robotsPlaced++;
            }
        }
    }

    // Method to update the city (simulate robots moving down one row)
    public static void update(int[][] cityArray) {
        int rows = cityArray.length;
        int cols = cityArray[0].length;

        // Robots "move" downward one row (start from the bottom to avoid overwriting)
        for (int c = 0; c < cols; c++) {
            for (int r = rows - 1; r > 0; r--) {
                if (cityArray[r][c] < 0) { // If there's a robot at this position
                    cityArray[r][c] = -cityArray[r][c];      // Remove robot from current cell
                    cityArray[r - 1][c] = -Math.abs(cityArray[r - 1][c]); // Move robot up one row
                }
            }
        }

        // Clear robots that have moved out of the grid (last row)
        for (int c = 0; c < cols; c++) {
            if (cityArray[rows - 1][c] < 0) {
                cityArray[rows - 1][c] = 0; // Robots leaving the grid are removed
            }
        }
    }

    // Method to display the current state of the city
    public static void display(int[][] cityArray) {
        int rows = cityArray.length;
        int cols = cityArray[0].length;

        // Print the city grid starting from the top row
        for (int i = cols - 1; i >= 0; i--) {
            for (int[] row : cityArray) {
                System.out.printf("%5d", row[i]); // Print each cell, formatted for clarity
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        // Randomly determing the number of rows and columns for the city (between 10 and 15)
        int rows = randomGenerator.nextInt(6) + 10; 
        int cols = randomGenerator.nextInt(6) + 10; 

        int[][] cityArray = new int[rows][cols]; // Initialize the city grid
        buildCity(cityArray); // Build the city
        display(cityArray);   // Display the initial city

        invade(cityArray);    // Simulate robot invasion
        display(cityArray);   // Display the city after invasion

        // Simulating 5 rounds of updates (robots moving)
        for (int i = 0; i < 5; i++) {
            update(cityArray);
            display(cityArray); // Display the city after each update
        }
    }
}
