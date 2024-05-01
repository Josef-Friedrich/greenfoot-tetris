package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

/**
 * Ein Tetromino ist ein Spielstein in Form von vier Blöcken.
 */
public abstract class Tetromino
{
    /**
     * Die Reihenfolge der Tetrominos wurde so übernommen, wie sie für den
     * damaligen <a href=
     * "https://harddrop.com/wiki/File:GBrandomizer.png">Zufallsgenerator</a>
     * des ursprünglichen Gameboys aufgereiht wurden.
     */
    public static String[] names = { "L", "J", "I", "O", "Z", "S", "T" };

    protected Scene scene;

    protected BlockGrid grid;

    protected int x;

    protected int y;

    protected Block[] blocks;

    public int rotation;

    /**
     * Show different block images for debugging purposes.
     */
    protected boolean debug;

    Tetromino(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        this.scene = scene;
        this.grid = grid;
        this.x = x;
        this.y = y;
        blocks = new Block[4];
        this.debug = debug;
    }

    Tetromino(Scene scene, BlockGrid grid, int x, int y)
    {
        this(scene, grid, x, y, false);
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

    /**
     * Entfernt alle Blöcke des Tetrominos aus dem Blockgitter.
     *
     * Die Blöcke könnten nicht einzeln im Block verschoben werden, da sie sich
     * sonst gegenseitig überschreiben würden.
     *
     * @see #addToGrid()
     */
    protected void removeFromGrid()
    {
        for (int i = 0; i < blocks.length; i++)
        {
            grid.removeBlock(blocks[i]);
        }
    }

    /**
     * Fügt alle Blöcke des Tetrominos in das Blockgitter ein.
     *
     * Die Blöcke könnten nicht einzeln im Block verschoben werden, da sie sich
     * sonst gegenseitig überschreiben würden.
     *
     * @see #removeFromGrid()
     */
    protected void addToGrid()
    {
        for (int i = 0; i < blocks.length; i++)
        {
            grid.addBlock(blocks[i]);
        }
    }

    public void moveLeft()
    {
        removeFromGrid();
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveLeft();
        }
        addToGrid();
    }

    public void moveRight()
    {
        removeFromGrid();
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveRight();
        }
        addToGrid();
    }

    public void moveDown()
    {
        removeFromGrid();
        for (int i = 0; i < blocks.length; i++)
        {
            blocks[i].moveDown();
        }
        addToGrid();
    }

    protected abstract void doRotation();

    public void rotate()
    {
        removeFromGrid();
        if (rotation > 2)
        {
            rotation = 0;
        }
        else
        {
            rotation++;
        }
        doRotation();
        addToGrid();
    }

    public static Tetromino create(Scene scene, BlockGrid grid, int number,
            int x, int y, boolean debug)
    {
        switch (number)
        {
        case 0:
            return new L(scene, grid, x, y, debug);

        case 1:
            return new J(scene, grid, x, y, debug);

        case 2:
            return new I(scene, grid, x, y, debug);

        case 3:
            return new O(scene, grid, x, y, debug);

        case 4:
            return new Z(scene, grid, x, y, debug);

        case 5:
            return new S(scene, grid, x, y, debug);

        case 6:
            return new T(scene, grid, x, y, debug);

        default:
            return new L(scene, grid, x, y, debug);
        }
    }

    public static Tetromino create(Scene scene, BlockGrid grid, String name,
            int x, int y, boolean debug)
    {
        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equals(name))
            {
                return create(scene, grid, i, x, y, debug);
            }
        }
        return create(scene, grid, 0, x, y, debug);
    }
}
