import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputs
        int height = 0;
        int width = 0;
        int square = 0;
        int edge = 0;

        // Input for height
        do {
            System.out.print("Input height: ");
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if (height <= 0) {
                    System.out.println("Error: Enter positive integer."); //for wrong numbers
                }
            } 
            else {
                System.out.println("Error: Enter valid integer."); //for wrong inputs like characters
                scanner.next(); //consume the invalid input
            }
        } while (height <= 0); //loop stop

        // Input for width
        do {
            System.out.print("Input width: ");
            if (scanner.hasNextInt()) {
                width = scanner.nextInt();
                if (width <= 0) {
                    System.out.println("Error: Enter positive integer for width.");
                }
            } 
            else {
                System.out.println("Error: Enter valid integer.");
                scanner.next();
            }
        } while (width <= 0);

        // Input for box
        do {
            System.out.print("Input square size: ");
            if (scanner.hasNextInt()) {
                square = scanner.nextInt();
                if (square <= 0) {
                    System.out.println("Error: Enter positive integer for square size.");
                }
            } else {
                System.out.println("Error: Enter valid integer.");
                scanner.next();
            }
        } while (square <= 0);

        // Input for edge
        do {
            System.out.print("Input edge length: ");
            if (scanner.hasNextInt()) {
                edge = scanner.nextInt();
                if (edge <= 0) {
                    System.out.println("Error: Enter positive integer for edge length.");
                }
            } else {
                System.out.println("Error: Enter valid integer.");
                scanner.next(); 
            }
        } while (edge <= 0);

        // Set height to 0
        int currentHeight = 0;

        // Loop for rows of boxes
        while (currentHeight < height) {
            // Loop for each row of boxes
            for (int row = 0; row < width; row++) {
                if ((currentHeight%(square+edge) == (square-1)) || (currentHeight%(square+edge) == 0)){
                    // Checking top or bottom
                    if ((row%(square+edge) == 0) || (row%(square+edge) == (square - 1))) {
                        // Draw the top and bottom border of the box
                        System.out.print("#");
                    }
                    else if ((row%(square+edge) < (square-1))) {
                        System.out.print("-");
                    } 
                    else if ((row%(square+edge))>(square-1)){
                        //if box is even
                        if (square%2==0 && (currentHeight%(square+edge)==(square/2) || currentHeight%(square+edge)==((square/2)-1))) {  
                            System.out.print("-");
                        }
                        //if box is odd
                        else if (square%2==1 && (currentHeight%(square+edge)==(square/2))) {
                            System.out.print("-");
                        }
                        //space without edges
                        else {
                            System.out.print(" ");
                        }
                    }
                }
                // horizontal edges between boxes
                if ((currentHeight%(square+edge) < (square-1)) && (currentHeight%(square+edge) > 0)){
                    if ((row%(square+edge) == 0) || (row%(square+edge) == (square - 1))) {
                        // middle rows of the box
                        System.out.print("|");
                    }
                    else if ((row%(square+edge)<(square-1)) && (row%(square+edge) > (0))) {
                        System.out.print(" ");
                    }
                    else if (row%(square+edge)>square-1){
                        System.out.print(" ");
                    }
                }
                else if ((currentHeight%(square+edge))>(square-1)){
                    //if box is even
                    if (square%2==0 && (row%(square+edge)==(square/2) || row%(square+edge)==((square/2)-1))) {  
                        System.out.print("|");
                    }
                    //if box is odd
                    else if (square%2==1 && (row%(square+edge)==(square/2))) {
                        System.out.print("|");
                    }
                    //space without edges
                    else {
                        System.out.print(" ");
                    }
                }
            }
            currentHeight += 1;
            System.out.println();
        }
    }
}