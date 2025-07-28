import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int numShips = 0;

        // grid size
        while (true) {
            System.out.print("Enter grid size (20 to 40): ");
            size = sc.nextInt();
            if (size >= 20 && size <= 40) {
                break;
            }
            System.out.println("Invalid size. Must be between 20 and 40.");
        }

        // number of ships
        while (true) {
            System.out.print("Enter number of ships: ");
            numShips = sc.nextInt();
            if (numShips > 0) {
                break;
            }
            System.out.println("Invalid number of ships. Must be greater than 0.");
        }

        Grid grid = new Grid(size, numShips);

        Ship[] ships = grid.getShips();

        int index = 0;
        if (numShips >= 1) {
            ships[index++] = new ShipCarrier();
        }
        if (numShips >= 2) {
            ships[index++] = new ShipFrigate();
        }
        while (index < numShips) {
            ships[index++] = new ShipDestroyer();
        }

        for (int i = 0; i < numShips; i++) {
            boolean placed = false;
            while (!placed) {
                ships[i].randomize(grid);
                // checking overlap
                if (!overlaps(i, ships)) {
                    grid.setShip(i, ships[i]);
                    grid.placeShipOnGrid(i);
                    placed = true;
                }
            }
        }

        // grid draw
        grid.draw();

        System.out.println("Ships:");
        for (int i = 0; i < numShips; i++) {
            Ship s = ships[i];
            String typeName;
            if (s instanceof ShipCarrier) typeName = "Carrier";
            else if (s instanceof ShipFrigate) typeName = "Frigate";
            else if (s instanceof ShipDestroyer) typeName = "Destroyer";
            else typeName = "Unknown";

            System.out.print(typeName + " coordinates: ");
            int[][] c = s.getCoords();
            for (int[] coord : c) {
                System.out.print("(" + coord[0] + "," + coord[1] + ") ");
            }
            System.out.println();
        }

        sc.close();
    }

    // checking for overlap
    private static boolean overlaps(int currentIndex, Ship[] ships) {
        Ship currentShip = ships[currentIndex];
        int[][] currCoords = currentShip.getCoords();

        for (int i = 0; i < currentIndex; i++) {
            Ship otherShip = ships[i];
            int[][] otherCoords = otherShip.getCoords();
            for (int j = 0; j < currCoords.length; j++) {
                for (int k = 0; k < otherCoords.length; k++) {
                    if (currCoords[j][0] == otherCoords[k][0] && currCoords[j][1] == otherCoords[k][1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}