package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Vector;

/**
 * Ein Blockgitter, das die Positionen aller Blöcke speichert.
 *
 * Herz dieser Klasse ist ein zweidimensionales Array/Feld aus Blöcken.
 */
public class Grid
{
    /**
     * Das zweidimensionale Array, das die Blöcke speichert.
     *
     * Die erste Dimension ist die x-Koordinate, die zweite die y-Koordinate.
     */
    private Block[][] grid;

    public Grid(int width, int height)
    {
        grid = new Block[width][height];
    }

    /**
     * Gibt die Breite des Blockgitters zurücks, also die Anzahl der Blöcke in
     * x-Richtung.
     *
     * @return Die Breite des Blockgitters.
     */
    public int getWidth()
    {
        return grid.length;
    }

    /**
     * Gibt die Höhe des Blockgitters zurücks, also die Anzahl der Blöcke in
     * y-Richtung.
     *
     * @return Die Höhe des Blockgitters.
     */
    public int getHeight()
    {
        return grid[0].length;
    }

    /**
     * Fügt einen Block zum Blockgitter hinzu.
     *
     * @param block Der Block, der hinzugefügt werden soll.
     */
    public void addBlock(Block block)
    {
        grid[block.getX()][block.getY()] = block;
    }

    /**
     * Entfernt einen Block aus dem Blockgitter.
     *
     * @param block Der Block, der entfernt werden soll.
     */
    public void removeBlock(Block block)
    {
        grid[block.getX()][block.getY()] = null;
    }

    /**
     * Überprüft, ob die angegebene Koordinate im Blockgitter besetzt ist.
     *
     * @param x Die entsprechende x-Koordinate der zu überprüfenden Position.
     * @param y Die entsprechende y-Koordinate der zu überprüfenden Position.
     *
     * @return Wahr, wenn die Koordinate besetzt ist, falsch sonst.
     */
    public boolean isTaken(int x, int y)
    {
        return x < 0 || x >= getWidth() || y < 0 || y >= getHeight()
                || grid[x][y] != null;
    }

    public boolean isTaken(Vector position)
    {
        return isTaken((int) position.getX(), (int) position.getY());
    }

    /**
     * Gib eine Textrepräsentation des Blockgitters und der momentation
     * enthaltenen Blöcke aus.
     *
     * Diese Methode ist nur für Testzwecke gedacht.
     */
    public void print()
    {
        String horizontalLine = "-".repeat(getWidth() + 2);
        System.out.println(horizontalLine);
        for (int y = getHeight() - 1; y > -1; y--)
        {
            System.out.print('|');
            for (int x = 0; x < getWidth(); x++)
            {
                if (grid[x][y] == null)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(grid[x][y].getChar());
                }
            }
            System.out.println('|');
        }
        System.out.println(horizontalLine);
    }
}
