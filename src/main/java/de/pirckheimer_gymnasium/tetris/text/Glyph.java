package de.pirckheimer_gymnasium.tetris.text;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import de.pirckheimer_gymnasium.engine_pi.Scene;
import de.pirckheimer_gymnasium.engine_pi.actor.Image;
import de.pirckheimer_gymnasium.engine_pi.util.ImageUtil;
import de.pirckheimer_gymnasium.tetris.Tetris;

/**
 * Eine Glyphe bzw. ein Buchstabe.
 */
class Glyph
{
    /**
     * Eine Referenz auf die {@link Scene Szene}, in der der Buchstabe angezeigt
     * werden soll.
     *
     * <p>
     * Wird benötigen diese Referenz, um den Buchstabe in die {@link Scene
     * Szene} einzufügen ({@link Scene#add}) bzw. aus der {@link Scene Szene} zu
     * entfernen ({@link Scene#remove}).
     */
    private Scene scene;

    private Image image;

    Glyph(Scene scene, char glyph, Color color, int x, int y)
    {
        this.scene = scene;
        BufferedImage bufferedImage = null;
        try
        {
            bufferedImage = de.pirckheimer_gymnasium.tetris.Image
                    .read(getImagePath(glyph));
        }
        catch (Exception e)
        {
            // ignore
        }
        if (bufferedImage != null)
        {
            bufferedImage = convertColorspace(bufferedImage,
                    BufferedImage.TYPE_INT_ARGB);
            bufferedImage = ImageUtil.scale(
                    ImageUtil.replaceColor(bufferedImage, Color.BLACK, color),
                    Tetris.SCALE);
            image = new Image(bufferedImage, Tetris.SCALE * Tetris.BLOCK_SIZE);
            image.setPosition(x, y);
            scene.add(image);
        }
    }

    private String convertGlyphToImageName(char glyph)
    {
        switch (glyph)
        {
        case '.':
            return "dot";

        case ',':
            return "comma";

        case '"':
            return "quotes";

        case '©':
            return "copyright";

        default:
            return String.valueOf(glyph);
        }
    }

    private String getImagePath(char glyph)
    {
        return "glyphs/" + convertGlyphToImageName(glyph) + ".png";
    }

    final private static BufferedImage convertColorspace(BufferedImage image,
            int newType)
    {
        BufferedImage raw = image;
        image = new BufferedImage(raw.getWidth(), raw.getHeight(), newType);
        ColorConvertOp op = new ColorConvertOp(null);
        op.filter(raw, image);
        return image;
    }

    /**
     * Entfernt den Buchstaben aus der {@link Scene Szene}.
     */
    public void remove()
    {
        if (image == null)
        {
            return;
        }
        scene.remove(image);
    }
}
