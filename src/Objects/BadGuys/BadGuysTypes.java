package Objects.BadGuys;


public enum BadGuysTypes {
    BAD_GUYS_01 (5,1, "rodrigo.jpg"),
    BAD_GUYS_02 (10,2, "francisco.jpg"),
    BAD_GUYS_03 (20,4, "pedro.jpg");

    private int health;
    private int speed;
    private String image;

    //01, 02 or 03, chooses badguy (associate player's level to select bad guy)
    /**
     * Constructor of BadGuys Types
     * @param health
     * @param speed
     * @param image
     */
    BadGuysTypes(int health, int speed, String image) {
        this.health = health;
        this.speed = speed;
        this.image = image;
    }
}
