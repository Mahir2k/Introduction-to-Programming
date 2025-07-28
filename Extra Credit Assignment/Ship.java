public abstract class Ship {
    protected int[][] coords;
    protected int[] damage;

    public Ship(int length) {
        coords = new int[length][2]; // {x, y} for entry
        damage = new int[length];
        for (int i = 0; i < length; i++) {
            damage[i] = 0;
        }
    }

    public int[][] getCoords() {
        return coords;
    }

    public int[] getDamage() {
        return damage;
    }

    public boolean test(int x, int y) {
        // Checking (x,y)
        for (int i = 0; i < coords.length; i++) {
            if (coords[i][0] == x && coords[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    public abstract void randomize(Grid g);
}