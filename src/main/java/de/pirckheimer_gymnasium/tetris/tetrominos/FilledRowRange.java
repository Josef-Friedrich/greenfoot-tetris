package de.pirckheimer_gymnasium.tetris.tetrominos;

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
        return to - from + 1;
    }
}
