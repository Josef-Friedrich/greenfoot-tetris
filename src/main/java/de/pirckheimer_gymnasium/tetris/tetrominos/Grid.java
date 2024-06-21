package de.pirckheimer_gymnasium.tetris.tetrominos;

/**
 * Ein Blockgitter, das die Positionen aller Blöcke speichert.
 *
 * <p>
 * Das „Herz“ dieser Klasse ist ein zweidimensionales Array/Feld aus Blöcken.
 * </p>
 */
public class Grid
{
    /**
     * Das zweidimensionale Array, das die Blöcke speichert.
     *
     * <p>
     * Die erste Dimension ist die x-Koordinate, die zweite die y-Koordinate.
     * </p>
     */
    private Block[][] grid;

    public Grid(int width, int height)
    {
        grid = new Block[width][height];
    }

    /**
     * Gibt die Breite des Blockgitters zurück, also die Anzahl der Blöcke in
     * x-Richtung.
     *
     * @return Die Breite des Blockgitters.
     */
    public int getWidth()
    {
        return grid.length;
    }

    /**
     * Gibt die Höhe des Blockgitters zurück, also die Anzahl der Blöcke in
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
        assert grid[block.getX()][block.getY()] == null;
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
     * @return Wahr, wenn die Koordinate besetzt ist, sonst falsch.
     */
    public boolean isTaken(int x, int y)
    {
        return x < 0 || x >= getWidth() || y < 0 || y >= getHeight()
                || grid[x][y] != null;
    }

    private boolean isRowFull(int y)
    {
        for (int x = 0; x < getWidth(); x++)
        {
            if (grid[x][y] == null)
            {
                return false;
            }
        }
        return true;
    }

    public FilledRowRange getFilledRowRange()
    {
        int from = -1;
        int to = -1;
        for (int y = 0; y < getHeight(); y++)
        {
            if (isRowFull(y))
            {
                if (from == -1)
                {
                    from = y;
                }
                to = y;
            }
        }
        if (from > -1 && to > -1)
        {
            return new FilledRowRange(from, to);
        }
        return null;
    }

    /**
     * Löscht alle Blöcke aus einer Zeile.
     *
     * @param y Die y-Koordinate der Zeile aus der Blöche gelöscht werden
     *          sollen.
     */
    private void clearRow(int y)
    {
        for (int x = 0; x < getWidth(); x++)
        {
            if (isTaken(x, y))
            {
                grid[x][y].remove();
                grid[x][y] = null;
            }
        }
    }

    /**
     * Leert das ganze Gitter.
     *
     * @see de.pirckheimer_gymnasium.tetris.debug.GridDebugScene
     */
    public void clear()
    {
        for (int y = 0; y < getHeight(); y++)
        {
            clearRow(y);
        }
    }

    public void removeFilledRowRange(FilledRowRange range)
    {
        for (int y = range.getFrom(); y <= range.getTo(); y++)
        {
            clearRow(y);
        }
    }

    /**
     * Löst einen Erdrutsch (landslide) aus, das heißt alle Blöcke oberhalb des
     * getilgten Bereichs werden nach unten bewegt.
     *
     * @param range Der getilgte Bereich mit vollen Zeilen.
     */
    public void triggerLandslide(FilledRowRange range)
    {
        for (int y = range.getTo() + 1; y < getHeight(); y++)
        {
            for (int x = 0; x < getWidth(); x++)
            {
                if (isTaken(x, y))
                {
                    Block block = grid[x][y];
                    block.moveBy(0, -range.getRowCount());
                    grid[x][y] = null;
                    grid[x][y - range.getRowCount()] = block;
                }
            }
        }
    }

    /**
     * Gib eine Textrepräsentation des Blockgitters und der momentan enthaltenen
     * Blöcke aus.
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
