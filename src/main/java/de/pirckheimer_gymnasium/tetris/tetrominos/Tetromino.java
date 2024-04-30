package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;
import de.pirckheimer_gymnasium.tetris.blocks.Block;

public abstract class Tetromino
{
    /**
     * Die Reihenfolge der Tetrominos wurde so übernommen, wie sie für den
     * damaligen <a href=
     * "https://harddrop.com/wiki/File:GBrandomizer.png">Zufallsgenerator</a>
     * aufgereiht wurden.
     */
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

    public static Tetromino create(int number, Scene scene, int x, int y,
            boolean debug)
    {
        switch (number)
        {
        case 0:
            return new L(scene, x, y, debug);

        case 1:
            return new J(scene, x, y, debug);

        case 2:
            return new I(scene, x, y, debug);

        case 3:
            return new O(scene, x, y, debug);

        case 4:
            return new Z(scene, x, y, debug);

        case 5:
            return new S(scene, x, y, debug);

        case 6:
            return new T(scene, x, y, debug);

        default:
            return new L(scene, x, y, debug);
        }
    }

    public static Tetromino create(String name, Scene scene, int x, int y,
            boolean debug)
    {
        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equals(name))
            {
                return create(i, scene, x, y, debug);
            }
        }
        return create(0, scene, x, y, debug);
    }
}
