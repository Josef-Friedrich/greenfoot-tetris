package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;
import de.pirckheimer_gymnasium.tetris.blocks.Block;

public abstract class Tetromino
{
    public static String[] names = { "L", "J", "I", "O", "Z", "S", "T" };

    protected Scene scene;

    protected Block[] blocks;

    protected int x;

    protected int y;

    public int rotation;

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

    public static Tetromino create(String name, Scene scene, int x, int y,
            boolean debug)
    {
        switch (name)
        {
        case "L":
            return new L(scene, x, y, debug);

        case "J":
            return new J(scene, x, y, debug);

        case "I":
            return new I(scene, x, y, debug);

        case "O":
            return new O(scene, x, y, debug);

        case "Z":
            return new Z(scene, x, y, debug);

        case "S":
            return new S(scene, x, y, debug);

        case "T":
            return new T(scene, x, y, debug);

        default:
            return new L(scene, x, y, debug);
        }
    }
}
