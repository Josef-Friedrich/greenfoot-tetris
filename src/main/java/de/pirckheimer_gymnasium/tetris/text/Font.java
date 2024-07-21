package de.pirckheimer_gymnasium.tetris.text;

import static de.pirckheimer_gymnasium.tetris.Tetris.COLOR_SCHEME_GREEN;

import de.pirckheimer_gymnasium.engine_pi.actor.ImageFont;
import de.pirckheimer_gymnasium.engine_pi.actor.ImageFontCaseSensitivity;

public class Font
{
    private static ImageFont font;

    public static ImageFont getFont()
    {
        if (font == null)
        {
            font = new ImageFont("image-font")
                    .setCaseSensitivity(ImageFontCaseSensitivity.TO_UPPER)
                    .setColor(COLOR_SCHEME_GREEN.getBlack())
                    .addMapping('\uE000', "e000_quotation-mark-and-dot");
        }
        return font;
    }
}
