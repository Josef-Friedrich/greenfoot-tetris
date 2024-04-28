package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.blocks.Block;

public abstract class Tetromino
{
    protected Scene scene;

    protected Block[] blocks;

    protected int x;

    protected int y;

    protected int rotation;

    /**
     * Show different block images for debugging purposes.
     */
    protected boolean debug;

    Tetromino(Scene scene, int x, int y, boolean debug)
    {
        this.x = x;
        this.y = y;
        this.scene = scene;
        blocks = new Block[4];
        this.debug = debug;
    }

    Tetromino(Scene scene, int x, int y)
    {
        this(scene, x, y, false);
    }

    protected Block createBlock(String name, int x, int y)
    {
        return new Block(this.scene, name, x, y);
    }

    protected void addBlock(int index, String name, int x, int y)
    {
        if (debug)
        {
            blocks[index] = createBlock("Debug-" + index, x, y);
        }
        else
        {
            blocks[index] = createBlock(name, x, y);
        }
    }

    public void moveLeft()
    {
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveLeft();
        }
    }

    public void moveRight()
    {
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveRight();
        }
    }

    public void moveDown()
    {
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveDown();
        }
    }

    public void rotate()
    {
        if (rotation > 2)
        {
            rotation = 0;
        }
        else
        {
            rotation++;
        }
    }
}
