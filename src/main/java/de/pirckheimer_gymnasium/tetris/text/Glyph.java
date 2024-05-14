package de.pirckheimer_gymnasium.tetris.text;

import java.awt.image.BufferedImage;

import de.pirckheimer_gymnasium.tetris.Tetris;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.actor.Image;
import rocks.friedrich.engine_omega.util.ImageUtil;

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

    Glyph(Scene scene, char glyph, String color, int x, int y)
    {
        this.scene = scene;
        try
        {
            BufferedImage bufferedImage = de.pirckheimer_gymnasium.tetris.Image
                    .read("glyphs/" + glyph + ".png");
            bufferedImage = ImageUtil
                    .scale(ImageUtil.replaceColors(bufferedImage, new String[]
                    { "#000000" }, new String[] { color }), Tetris.SCALE);
            this.image = new Image(bufferedImage,
                    Tetris.SCALE * Tetris.BLOCK_SIZE);
            this.image.setPosition(x, y);
            scene.add(this.image);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Entfernt den Buchstaben aus der {@link Scene Szene}.
     */
    public void remove()
    {
        this.scene.remove(this.image);
    }
}
