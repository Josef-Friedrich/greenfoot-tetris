package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.Vector;

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

    /**
     * Eine Referenz auf die {@link Scene Szene}, in der der Tetromino erstellt
     * wurde. Diese Referenz wird an die Block-Klasse weitergereicht.
     */
    protected Scene scene;

    protected Grid grid;

    protected String name;

    /**
     * Die x-Koordinate des Tetrominos entspricht der Lage des ersten Blocks,
     * also dem Block mit der Indexnummer 0 im Blockfeld.
     */
    protected int x;

    /**
     * Die y-Koordinate des Tetrominos entspricht der Lage des ersten Blocks,
     * also dem Block mit der Indexnummer 0 im Blockfeld.
     */
    protected int y;

    protected Block[] blocks;

    /**
     * Die Rotation des Tetrominos.
     */
    public int rotation;

    public Tetromino(Scene scene, Grid grid, String name, int x, int y)
    {
        this.scene = scene;
        this.name = name;
        this.grid = grid;
        this.x = x;
        this.y = y;
        blocks = new Block[4];
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    /**
     * Fügt einen Block ein.
     *
     * @param index Die Indexnummer im Blockfeld.
     * @param x     Die x-Koordinate, an der der Block eingefügt werden soll.
     * @param y     Die y-Koordinate, an der der Block eingefügt werden soll.
     */
    protected void addBlock(int index, int x, int y)
    {
        Block block;
        if (Game.isDebug())
        {
            block = new Block(this.scene, "Debug-" + index, x, y);
        }
        else
        {
            block = new Block(this.scene, name, x, y);
        }
        blocks[index] = block;
        if (grid != null)
        {
            grid.addBlock(block);
        }
    }

    /**
     * Bewegt einen Block an eine neue Position durch Angabe eines relativen
     * Vectors.
     *
     * @param index Die Indexnummer, die angibt, welcher Block verschoben werden
     *              soll.
     * @param dX    Delta-Wert der Bewegung in x-Richtung.
     * @param dY    Delta-Wert der Bewegung in y-Richtung.
     */
    protected void moveBlock(int index, int dX, int dY)
    {
        blocks[index].moveBy(dX, dY);
    }

    /**
     * Überprüft, ob die gegebene Kooordinate mit einem der vier eigenen Blöcke
     * des Tetrominos übereinstimmt.
     */
    public boolean isOwnBlockPosition(int x, int y)
    {
        for (Block block : blocks)
        {
            if (block.getX() == x && block.getY() == y)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Überprüft, ob die gegebene Kooordinate mit einem der vier eigenen Blöcke
     * des Tetrominos übereinstimmt.
     */
    public boolean isOwnBlockPosition(Vector position)
    {
        return isOwnBlockPosition((int) position.getX(), (int) position.getY());
    }

    /**
     * Überprüft, ob die gegebene Koordinate im Blockgitter besetzt ist. Dabei
     * wird ein eigener Block ignoriert.
     */
    protected boolean isGridTaken(int x, int y)
    {
        if (grid == null)
        {
            return false;
        }
        return !isOwnBlockPosition(x, y) && grid.isTaken(x, y);
    }

    /**
     * Überprüft, ob die gegebene Koordinate im Blockgitter besetzt ist. Dabei
     * wird ein eigener Block ignoriert.
     */
    protected boolean isGridTaken(Vector position)
    {
        if (position == null)
        {
            return false;
        }
        return isGridTaken((int) position.getX(), (int) position.getY());
    }

    /**
     * Diese Methode wird benötigt, um Tetrominos außerhalb des Grids zu
     * rotieren und dann in die gewünschte Endposition zu bringen. So können wir
     * ein vorbelegtes Gitter erzeugen, um den Algorithmus zu testen wie
     * ausgefüllte Reihen aus dem Gitter gelöscht werden. Die Tetrominos werden
     * zunächst ohne Gitter erzeugt ({@code grid = null}), dann rotiert und an
     * die gewünschte Position geschoben und schließlich wird diese Methode
     * aufgerufen und die Blöcke werden dem Gitter hinzugefügt.
     *
     * @param grid
     */
    public void addGrid(Grid grid)
    {
        this.grid = grid;
        addBlocksToGrid();
    }

    /**
     * Fügt alle Blöcke des Tetrominos in das Blockgitter ein.
     *
     * Die Blöcke können nicht einzeln im Gitter verschoben werden, da sie sich
     * sonst gegenseitig überschreiben würden.
     *
     * @see #removeBlocksFromGrid()
     */
    protected void addBlocksToGrid()
    {
        if (grid == null)
        {
            return;
        }
        for (Block block : blocks)
        {
            grid.addBlock(block);
        }
    }

    /**
     * Entfernt alle Blöcke des Tetrominos aus dem Blockgitter.
     *
     * Die Blöcke können nicht einzeln im Gitter verschoben werden, da sie sich
     * sonst gegenseitig überschreiben würden.
     *
     * @see #addBlocksToGrid()
     */
    protected void removeBlocksFromGrid()
    {
        if (grid == null)
        {
            return;
        }
        for (Block block : blocks)
        {
            grid.removeBlock(block);
        }
    }

    protected Block[] getBlocks(int... indices)
    {
        Block[] result = new Block[indices.length];
        for (int i = 0; i < indices.length; i++)
        {
            result[i] = blocks[indices[i]];
        }
        return result;
    }

    protected boolean checkLeft()
    {
        for (Block block : blocks)
        {
            if (isGridTaken(block.getX() - 1, block.getY()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean moveLeft()
    {
        if (!checkLeft())
        {
            return false;
        }
        removeBlocksFromGrid();
        for (Block block : blocks)
        {
            block.moveLeft();
        }
        addBlocksToGrid();
        x--;
        assert x == blocks[0].getX();
        return true;
    }

    protected boolean checkRight()
    {
        for (Block block : blocks)
        {
            if (isGridTaken(block.getX() + 1, block.getY()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean moveRight()
    {
        if (!checkRight())
        {
            return false;
        }
        removeBlocksFromGrid();
        for (Block block : blocks)
        {
            block.moveRight();
        }
        addBlocksToGrid();
        x++;
        assert x == blocks[0].getX();
        return true;
    }

    protected boolean checkDown()
    {
        for (Block block : blocks)
        {
            if (isGridTaken(block.getX(), block.getY() - 1))
            {
                return false;
            }
        }
        return true;
    }

    public boolean moveDown()
    {
        if (!checkDown())
        {
            return false;
        }
        removeBlocksFromGrid();
        for (Block block : blocks)
        {
            block.moveDown();
        }
        addBlocksToGrid();
        y--;
        assert y == blocks[0].getY();
        return true;
    }

    /**
     * Überprüft, ob sich das Tetromino drehen kann.
     *
     * <p>
     * Achtung das ist eine naive Implementation! Wir überprüfen einen 3x3-Block
     * um den Mittelpunkt des Tetromino.
     *
     * <p>
     * Probleme dieser Implementation:
     *
     * <ul>
     * <item>Das I-Tetromino schaut einen Block über den 3x3-Block
     * hinaus.</item>
     *
     * <item>In den 3x3-Feld dürfen sind an gewissen Position Blöcke befinden
     * und das Tetromino kann sich trotzdem bewegen.</item>
     * </ul>
     *
     * @return
     */
    private boolean checkRotation()
    {
        for (int x = getX() - 1; x <= getX() + 1; x++)
        {
            for (int y = getY() - 1; y <= getY() + 1; y++)
            {
                if (isGridTaken(x, y))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Führt die eigentliche Rotation des Tetrominos durch, d. h. sie bewegt
     * einzelnen Blöcke an neue Positionen.
     *
     * Es handelt sich um eine abstrakte Einschubmethode, die nach dem
     * Schablonenmethode-Entwurfsmuster (engl. template method) von den
     * Unterklassen - den einzelnen Tetrominos - implementiert werden müssen.
     *
     * @see #rotate
     */
    protected abstract void doRotation();

    /**
     * Führt eine Rechtsdrehung durch.
     *
     * Es handelt sich um eine Schablonenmethode (engl. template method) nach
     * dem gleichnamigen Entwurfsmuster. Die Methode ruft abstrakte Methoden
     * doRotation() auf, die erst in den Unterklassen der einzelnen Tetrominos
     * definiert werden.
     *
     * @see #doRotation
     *
     * @return Gibt wahr zurück, wenn sind das Tetromino drehen konnte, sonst
     *         falsch.
     */
    public boolean rotate()
    {
        if (!checkRotation())
        {
            return false;
        }
        if (rotation > 2)
        {
            rotation = 0;
        }
        else
        {
            rotation++;
        }
        removeBlocksFromGrid();
        doRotation();
        addBlocksToGrid();
        return true;
    }

    public void remove()
    {
        for (Block block : blocks)
        {
            block.remove();
        }
        removeBlocksFromGrid();
    }

    public static Tetromino create(Scene scene, Grid grid, String name, int x,
            int y)
    {
        switch (name)
        {
        case "L":
            return new L(scene, grid, x, y);

        case "J":
            return new J(scene, grid, x, y);

        case "I":
            return new I(scene, grid, x, y);

        case "O":
            return new O(scene, grid, x, y);

        case "Z":
            return new Z(scene, grid, x, y);

        case "S":
            return new S(scene, grid, x, y);

        case "T":
            return new T(scene, grid, x, y);

        default:
            return new L(scene, grid, x, y);
        }
    }

    public static Tetromino create(Scene scene, Grid grid, int number, int x,
            int y)
    {
        return create(scene, grid, names[number], x, y);
    }
}
