package org.academiadecodigo.PopStarsSpaceInvaders.gfx.simplegfx;

import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;
    private int height;
    private int width;
    private Rectangle screen;


    public SimpleGfxGrid(int cols, int rows) {
        this.height = rows * CELL_SIZE;
        this.width = cols * CELL_SIZE;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        Rectangle screen = new Rectangle(PADDING, PADDING, this.width, this.height);
        screen.draw();

    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return (this.width / getCellSize());
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return (this.height / getCellSize());
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        return CELL_SIZE;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition( col, row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return (row * CELL_SIZE + PADDING);
        // can use the Static constant CELL_SIZE or the method getCellSize()
        // throw new UnsupportedOperationException();
    }


    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return (column * getCellSize() + PADDING);
        // throw new UnsupportedOperationException();
    }
}
