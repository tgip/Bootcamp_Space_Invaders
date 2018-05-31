package org.academiadecodigo.PopStarsSpaceInvaders.grid;

import org.academiadecodigo.PopStarsSpaceInvaders.simplegfx.SimpleGfxGrid;

public class GridFactory {
    /**
     * Creates a new grid
     *
     * @param gridType the type of grid to create
     * @param cols     the number of columns of the grid
     * @param rows     the number of rows of the grid
     * @return the new grid
     */
    public static Grid makeGrid(GridType gridType, int cols, int rows) {

        switch (gridType) {
            case SIMPLE_GFX:
                return (Grid) new SimpleGfxGrid(cols, rows);
            default:
                throw new UnsupportedOperationException(); // return new LanternaGrid(cols, rows);
        }

    }
}
