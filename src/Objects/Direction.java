package Objects;


public enum Direction {
    N (0,1),
    NE (1,-1),
    E (-1,0),
    SE (-1,-1),
    S (0,-1),
    SW (1,-1),
    W (0,-1);

    private int x;
    private int y;

    /**
     * Constructor for directions of travel
     * @param x
     * @param y
     */
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
