package de.pirckheimer_gymnasium.tetris.tetrominos;

/**
 * Diese Klasse speichert, welche Reihen vollständig sind und daher getilgt
 * werden können.
 */
public class FilledRowRange
{
    int from;

    int to;

    public FilledRowRange(int from, int to)
    {
        this.from = from;
        this.to = to;
    }

    public int getFrom()
    {
        return from;
    }

    public int getTo()
    {
        return to;
    }

    /**
     * Gibt die Anzahl zurück, wie viele Reihen abgebaut wurden.
     *
     * @return die Anzahl an Reihen die abgebaut wurden.
     */
    public int getRowCount()
    {
        int result = to - from + 1;
        assert result > 0 && result < 5;
        return result;
    }
}
