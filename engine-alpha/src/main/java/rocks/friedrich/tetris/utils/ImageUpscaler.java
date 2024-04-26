package rocks.friedrich.tetris.utils;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * https://stackoverflow.com/a/62507011
 */
public class ImageUpscaler {

    private static String getFilePath(String pathname) {
        return ImageUpscaler.class.getClassLoader().getResource(pathname).getFile();
    }

    private static File getFile(String pathname) {
        return new File(getFilePath(pathname));
    }

    public static BufferedImage read(String pathname) throws IOException {
        return ImageIO.read(getFile(pathname));
    }

    public static void write(BufferedImage image, String pathname) throws IOException {
        ImageIO.write(image, "png", new File(pathname));
    }

    /**
     * https://stackoverflow.com/a/4216635
     */
    public static BufferedImage scale(BufferedImage before, int scale) {
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w * scale, h * scale, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        after = scaleOp.filter(before, after);
        return after;
    }

    /**
     * https://codereview.stackexchange.com/a/146611
     */
    public static BufferedImage changeColors(BufferedImage image, Color from, Color to) {
        int w = image.getWidth();
        int h = image.getHeight();
        int[] rgb = image.getRGB(0, 0, w, h, null, 0, w);
        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] == from.getRGB()) {
                rgb[i] = to.getRGB();
            }
        }
        image.setRGB(0, 0, w, h, rgb, 0, w);
        return image;

    }

}
