package de.pirckheimer_gymnasium.tetris;

import java.awt.Color;

import de.pirckheimer_gymnasium.engine_pi.util.ColorUtil;

/**
 * Das klassische Gameboy-Spiel hat ein Farbschema, das aus nur vier Farben
 * besteht.
 *
 * Wir verwenden als Farbnamen <em>weiß</em> ({@code white}), <em>hell</em>
 * ({@code light}), <em>dunkel</em> ({@code dark}) und <em>schwarz</em>
 * ({@code black}).
 */
public class ColorScheme
{
    private Color[] colors;

    public ColorScheme(Color white, Color light, Color dark, Color black)
    {
        colors = new Color[4];
        colors[0] = white;
        colors[1] = light;
        colors[2] = dark;
        colors[3] = black;
    }

    public ColorScheme(String white, String light, String dark, String black)
    {
        this(ColorUtil.decode(white), ColorUtil.decode(light),
                ColorUtil.decode(dark), ColorUtil.decode(black));
    }

    public Color[] getColors()
    {
        return colors;
    }

    public Color getWhite()
    {
        return colors[0];
    }

    public Color getLight()
    {
        return colors[1];
    }

    public Color getDark()
    {
        return colors[2];
    }

    public Color getBlack()
    {
        return colors[3];
    }
}
