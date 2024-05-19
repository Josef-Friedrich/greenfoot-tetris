package de.pirckheimer_gymnasium.tetris.text;

import rocks.friedrich.engine_omega.Scene;

/**
 * Ein rechteckiges Feld, in das mit den typischen Tetris-Buchstaben geschrieben
 * werden kann.
 */
public class TextField
{
    /**
     * Eine Referenz auf die {@link Scene Szene}, in der das Textfeld angezeigt
     * werden soll.
     */
    private Scene scene;

    /**
     * Die x-Koordinate des linken oberen Ecks des Textfelds, in das geschrieben
     * werden soll.
     */
    private int x;

    /**
     * Die y-Koordinate des linken oberen Ecks des Textfelds, in das geschrieben
     * werden soll.
     */
    private int y;

    /**
     * Die Anzahl an Zeilen, die das Textfeld maximal enthalten darf.
     */
    private int lines;

    /**
     * Die Anzahl an Buchstaben, die in eine Zeile passen.
     */
    private int width;

    /**
     * Ein zweidimensionales Feld, das als Speicher für die Buchstaben dient.
     */
    private TextLine[] textLines;

    /**
     *
     * @param scene Eine Referenz auf die {@link Scene Szene}, in der das
     *              Textfeld angezeigt werden soll.
     * @param x     Die x-Koordinate des linken oberen Ecks des Textfelds, in
     *              das geschrieben werden soll.
     * @param y     Die y-Koordinate des linken oberen Ecks des Textfelds, in
     *              das geschrieben werden soll.
     * @param lines Die Anzahl an Zeilen, die das Textfeld maximal enthalten
     *              darf.
     * @param width Die Anzahl an Buchstaben, die in eine Zeile passen.
     */
    public TextField(Scene scene, int x, int y, int lines, int width)
    {
        this.scene = scene;
        this.x = x;
        this.y = y;
        this.width = width;
        this.lines = lines;
        textLines = new TextLine[lines];
    }

    public void write(String text, String color)
    {
        clear();
        // Ist der Text null oder eine Zeichenkette mit keinem Zeichen, zeichnen
        // wir keinen Text und verlassen die Methode vorzeitig.
        if (text == null || text.length() == 0)
        {
            return;
        }
        if (text.length() > lines * width)
        {
            throw new RuntimeException("Der Text passt nicht in das Textfeld");
        }
    }

    /**
     * Löscht alle Zeilen aus dem Textfeld.
     */
    public void clear()
    {
        for (TextLine line : textLines)
        {
            if (line != null)
            {
                line.clear();
            }
        }
    }
}
