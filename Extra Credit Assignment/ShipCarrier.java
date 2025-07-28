import java.util.Random;

public class ShipCarrier extends Ship {
    public ShipCarrier() {
        super(5); // 5 squares for carrier
    }

    @Override
    public void randomize(Grid g) {
        Random rand = new Random();
        int size = g.getSize();
        boolean placed = false;

        while (!placed) {
            // random orientation
            int orientation = rand.nextInt(2);
            int startX = rand.nextInt(size);
            int startY = rand.nextInt(size);

            int[][] proposed = new int[5][2];
            boolean valid = true;

            for (int i = 0; i < 5; i++) {
                int x, y;
                if (orientation == 0) {
                    x = startX + i;
                    y = startY;
                } else {
                    x = startX;
                    y = startY + i;
                }
            }

            if (g.canPlaceShip(proposed)) {
                coords = proposed;
                placed = true;
            }
        }
    }
}