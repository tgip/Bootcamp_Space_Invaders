package org.academiadecodigo.PopStarsSpaceInvaders.grid;

public interface GridPosition {
    int getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    int getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    void setPos(int col, int row);

    /**
     * Gets the position getColor
     *
     * @return the position getColor
     */
    GridColor getColor();

    /**
     * Changes the getColor of this grid position
     *
     * @param color the new position getColor
     */
    void setColor(GridColor color);

    /**
     * Displays the position in the grid
     */
    void show();

    /**
     * Hides the position in the grid
     */
    void hide();

    /**
     * Moves this grid position towards a specified direction
     *
     * @param direction the direction to move to
     * @param distance  the number of positions to move
     */
    void moveInDirection(GridDirection direction, int distance);
    /*
    move right uma cells
     */

    /**
     * Tests equality with another position
     *
     * @param position the position to test against
     * @return true if positions are equal
     */
    boolean equals(GridPosition position);

}
