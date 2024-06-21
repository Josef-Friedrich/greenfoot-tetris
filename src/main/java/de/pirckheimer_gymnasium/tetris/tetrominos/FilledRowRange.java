package de.pirckheimer_gymnasium.tetris.tetrominos;

/**
 * Diese Klasse speichert, welche Zeilen vollständig sind und daher getilgt
 * werden können.
 *
 * <p>
 * Im Attribut {@link #from} steht der kleinere Wert. Ist nur eine Zeile
 * ausgefüllt, so steht in {@link from} und {@link to} der gleiche Wert.
 * </p>
 */
public class FilledRowRange
{
    /**
     * Ab welcher y-Koordinate (einschließlich) der Bereich mit ausgefüllten
     * Zeilen reicht.
     */
    private final int from;

    /**
     * Bis zu welcher y-Koordinate (einschließlich) der Bereich mit ausgefüllten
     * Zeilen reicht.
     */
    private final int to;

    /**
     * @param from Ab welcher y-Koordinate (einschließlich) der Bereich mit
     *             ausgefüllten Zeilen reicht.
     * @param to   Bis zu welcher y-Koordinate (einschließlich) der Bereich mit
     *             ausgefüllten Zeilen reicht.
     */
    public FilledRowRange(int from, int to)
    {
        this.from = from;
        this.to = to;
    }

    /**
     * Gibt zuürück ab welcher y-Koordinate (einschließlich) der Bereich mit
     * ausgefüllten Zeilen reicht.
     *
     * @return Ab welcher y-Koordinate (einschließlich) der Bereich mit
     *         ausgefüllten Zeilen reicht.
     */
    public int getFrom()
    {
        return from;
    }

    /**
     * Gibt zurück bis zu welcher y-Koordinate (einschließlich) der Bereich mit
     * ausgefüllten Zeilen reicht.
     *
     * @return Bis zu welcher y-Koordinate (einschließlich) der Bereich mit
     *         ausgefüllten Zeilen reicht.
     */
    public int getTo()
    {
        return to;
    }

    /**
     * Gibt die Anzahl zurück, wie viele Zeilen abgebaut wurden.
     *
     * @return Die Anzahl an Zeilen, die abgebaut wurden.
     */
    public int getRowCount()
    {
        int result = to - from + 1;
        assert result > 0 && result < 5;
        return result;
    }
}
