package org.academiadecodigo.PopStarsSpaceInvaders.simplegfx;

import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridColor;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.AbstractGridPosition;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridDirection;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private int col;
    private int row;
    private Rectangle rectangle;
    private SimpleGfxGrid grid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.grid = grid;
        rectangle = new Rectangle( (grid.getCellSize() * this.getCol()) + SimpleGfxGrid.PADDING,
                (grid.getCellSize() * this.getRow()) + grid.PADDING,
                grid.getCellSize(),
                grid.getCellSize());
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        this.grid = grid;
        rectangle = new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        show();

    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance){
        int lastRow = this.getRow();
        int lastCol = this.getCol();
        super.moveInDirection(direction, distance);

        rectangle.translate((this.getCol()-lastCol)*grid.getCellSize(), (this.getRow()-lastRow)*grid.getCellSize());
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}
