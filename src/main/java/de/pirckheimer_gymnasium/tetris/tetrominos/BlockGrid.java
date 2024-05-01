package de.pirckheimer_gymnasium.tetris.tetrominos;

public class BlockGrid
{
    Block[][] grid;

    public BlockGrid(int width, int height)
    {
        grid = new Block[width][height];
    }
    // public void addBlock(Block block, int x, int y)
    // {
    // grid[x][y] = block;
    // }
    // public void moveBlockBy(Block block, int dx, int dy)
    // {
    // grid[block.getX()][block.getY()] = null;
    // block.moveBy(dx, dy);
    // grid[block.getX()][block.getY()] = block;
    // }
}
