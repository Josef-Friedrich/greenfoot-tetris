package de.pirckheimer_gymnasium.tetris.tetrominos;

public class SoftDrop
{
    /**
     * Die y-Koordinate, bei der die Soft-Drop-Bewegung gestartet wurde.
     */
    private int y;

    private Tetromino tetromino;

    public SoftDrop(Tetromino tetromino)
    {
        y = tetromino.getY();
        this.tetromino = tetromino;
    }

    /**
     * Gibt die Distanz in Felder an, wie weit das Tetromino mittels Soft-Drop
     * nach unten bewegt wurde.
     *
     * @return Die Distanz in Felder der Soft-Drop-Bewegung.
     */
    public int getDistance()
    {
        int result = y - tetromino.getY();
        assert result > -1;
        return result;
    }
}
