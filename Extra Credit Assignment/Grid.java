import java.util.Arrays;

public class Grid {
    private int[][] grid;
    private Ship[] ships;

    public Grid(int size, int numShips) {
        grid = new int[size][size];
        for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            grid[i][j] = -1;
        }
    }
        ships = new Ship[numShips];
    }

    public int getSize() {
        return grid.length;
    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShip(int index, Ship s) {
        ships[index] = s;
    }

    public boolean isEmpty(int x, int y) {
        return grid[x][y] == -1;
    }

    public void placeShipOnGrid(int shipIndex) {
        Ship s = ships[shipIndex];
        int[][] coords = s.getCoords();
        for (int i = 0; i < coords.length; i++) {
            int x = coords[i][0];
            int y = coords[i][1];
            grid[x][y] = shipIndex;
        }
    }

    public boolean canPlaceShip(int[][] proposedCoords) {
        int size = getSize();
        for (int i = 0; i < proposedCoords.length; i++) {
        int x = proposedCoords[i][0];
        int y = proposedCoords[i][1];
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false; // Out of grid bounds
        }
        if (!isEmpty(x, y)) {
            return false; // occupied
        }
    }
    return true;
    }

    public void draw() {
        int size = getSize();
        // top border
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(" ");
            for (int j = 0; j < size; j++) {
                System.out.print("+---");
            }
            System.out.println("+");

            System.out.printf("%2d ", i);
            for (int j = 0; j < size; j++) {
                System.out.print("| ");
                int val = grid[i][j];
                if (val == -1) {
                    System.out.print(" ");
                } else {
                    // ship type
                    Ship s = ships[val];
                    char c;
                    if (s instanceof ShipCarrier) c = 'C';
                    else if (s instanceof ShipFrigate) c = 'F';
                    else if (s instanceof ShipDestroyer) c = 'D';
                    else c = '?';
                    System.out.print(c);
                }
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print(" ");
        for (int j = 0; j < size; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
