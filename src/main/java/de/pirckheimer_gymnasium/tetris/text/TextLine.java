package de.pirckheimer_gymnasium.tetris.text;

import java.awt.Color;

import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.actor.Rectangle;
import rocks.friedrich.engine_omega.util.ColorUtil;

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
     * Die x-Koordinate des linken unteren Ecks der Textzeile, in das
     * geschrieben werden soll.
     */
    private int x;

    /**
     * Die y-Koordinate des linken unteren Ecks der Textzeile, in das
     * geschrieben werden soll.
     */
    private int y;

    /**
     * Die Anzahl an Buchstaben, die in eine Zeile passen.
     */
    private int width;

    /**
     * Ein Feld, das als Speicher für die Buchstaben dient.
     */
    private Glyph[] glyphs;

    /**
     *
     * @param scene Eine Referenz auf die {@link Scene Szene}, in der das
     *              Textfeld angezeigt werden soll.
     * @param x     Die x-Koordinate des linken unteren Ecks der Textzeile, in
     *              das geschrieben werden soll.
     * @param y     Die y-Koordinate des linken unteren Ecks der Textzeile, in
     *              das geschrieben werden soll.
     * @param width Die Anzahl an Buchstaben, die in eine Zeile passen soll.
     */
    public TextLine(Scene scene, int x, int y, int width)
    {
        this.scene = scene;
        this.x = x;
        this.y = y;
        this.width = width;
        glyphs = new Glyph[width];
        if (Game.isDebug())
        {
            Rectangle rectangle = new Rectangle(width, 1);
            rectangle.setColor(ColorUtil.decode("#cccccccc"));
            rectangle.setPosition(x, y);
            scene.add(rectangle);
        }
    }

    public void write(String text, Color color, TextAlignment alignment)
    {
        // Die Zeichen löschen, die in einem früheren Aufruf eingezeichnet
        // wurden.
        clear();
        // Ist der Text null oder eine Zeichenkette mit keinem Zeichen, zeichnen
        // wir keinen Text und verlassen die Methode vorzeitig.
        if (text == null || text.length() == 0)
        {
            return;
        }
        // Wir werfen eine Ausnahme, falls der Text nicht in die Zeile passt.
        if (text.length() > width)
        {
            throw new RuntimeException("Der Text passt nicht in die Zeile!");
        }
        text = text.toUpperCase();
        int startIndex = 0;
        if (alignment == TextAlignment.CENTER)
        {
            startIndex = (width - text.length()) / 2;
        }
        else if (alignment == TextAlignment.RIGHT)
        {
            startIndex = width - text.length();
        }
        int charIndex = 0;
        for (int i = startIndex; i < text.length() + startIndex; i++)
        {
            glyphs[i] = new Glyph(this.scene, text.charAt(charIndex), color,
                    x + i, y);
            charIndex++;
        }
    }

    /**
     * Löscht alle Zeichen aus der Textzeile.
     */
    public void clear()
    {
        for (Glyph glyph : glyphs)
        {
            if (glyph != null)
            {
                glyph.remove();
            }
        }
    }
}
