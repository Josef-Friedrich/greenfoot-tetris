package de.pirckheimer_gymnasium.tetris.text;

import rocks.friedrich.engine_omega.Scene;

/**
 * Ein rechteckiges Feld, in das mit den typischen Tetris-Buchstaben geschrieben
 * werden kann.
 */
public class TextLine
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
     * Die Anzahl an Buchstaben, die in eine Zeile passen.
     */
    private int width;

    /**
     * Ein zweidimensionales Feld, das als Speicher für die Buchstaben dient.
     */
    private Glyph[] glyphs;

    /**
     *
     * @param scene Eine Referenz auf die {@link Scene Szene}, in der das
     *              Textfeld angezeigt werden soll.
     * @param x     Die x-Koordinate des linken oberen Ecks des Textfelds, in
     *              das geschrieben werden soll.
     * @param y     Die y-Koordinate des linken oberen Ecks des Textfelds, in
     *              das geschrieben werden soll.
     * @param width Die Anzahl an Buchstaben, die in eine Zeile passen.
     */
    public TextLine(Scene scene, int x, int y, int width)
    {
        this.scene = scene;
        this.x = x;
        this.y = y;
        this.width = width;
        glyphs = new Glyph[width];
    }

    public void write(String text, String color)
    {
        text = text.toUpperCase();
        int glyphIndex = 0;
        for (int i = 0; i < text.length(); i++)
        {
            glyphs[glyphIndex] = new Glyph(this.scene,
                    text.charAt(i), color, x + glyphIndex, y);
            glyphIndex++;
            if (glyphIndex > width - 1)
            {
                throw new RuntimeException(
                        "Der Text passt nicht in das Textfeld");
            }
        }
    }


    public void clearLine(int lineIndex)
    {
        for (Glyph glyph : glyphs)
        {
            if (glyph != null)
            {
                glyph.remove();
            }
        }
    }

    /**
     * Löscht alle Zeilen aus dem Textfeld.
     */
    public void clear()
    {
        for (int i = 0; i < glyphs.length; i++)
        {
            clearLine(i);
        }
    }
}
