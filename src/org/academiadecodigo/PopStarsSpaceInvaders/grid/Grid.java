package org.academiadecodigo.PopStarsSpaceInvaders.grid;

public interface Grid {
    void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    int getRows();

    int getHeight();

    int getWidth();

    int getCellSize();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    GridPosition makeGridPosition();

    /**
     * Creates a a grid position in a specific column and row
     *
     * @param col   the position column
     * @param row   the position row
     * @return the new grid position
     */
    GridPosition makeGridPosition(int col, int row);
}
