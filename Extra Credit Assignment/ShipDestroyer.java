import java.util.Random;

public class ShipDestroyer extends Ship {
    public ShipDestroyer() {
        super(2); // 2 squares for destroyerrr!!!
    }

    @Override
    public void randomize(Grid g) {
        Random rand = new Random();
        int size = g.getSize();
        boolean placed = false;

        while (!placed) {
            int orientation = rand.nextInt(2);
            int startX = rand.nextInt(size);
            int startY = rand.nextInt(size);

            int[][] proposed = new int[2][2];
            for (int i = 0; i < 2; i++) {
                int x, y;
                if (orientation == 0) {
                    x = startX + i;
                    y = startY;
                } else {
                    x = startX;
                    y = startY + i;
                }
                proposed[i][0] = x;
                proposed[i][1] = y;
            }

            if (g.canPlaceShip(proposed)) {
                coords = proposed;
                placed = true;
            }
        }
    }
}