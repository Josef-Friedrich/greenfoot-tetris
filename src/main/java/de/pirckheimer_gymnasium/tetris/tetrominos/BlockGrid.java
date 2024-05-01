package de.pirckheimer_gymnasium.tetris.tetrominos;

public class BlockGrid
{
    private Block[][] grid;

    public BlockGrid(int width, int height)
    {
        grid = new Block[width][height];
    }

    public void addBlock(Block block)
    {
        grid[block.getX()][block.getY()] = block;
    }

    public void moveBlock(int oldX, int oldY, int newX, int newY)
    {
        Block block = grid[oldX][oldY];
        grid[oldX][oldY] = null;
        grid[newX][newY] = block;
    }
}
