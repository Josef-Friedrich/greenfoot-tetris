package rocks.friedrich.tetris.utils;

import rocks.friedrich.tetris.Tetris;
import rocks.friedrich.tetris.color.ColorSchema;
import rocks.friedrich.tetris.color.GrayColorSchema;
import rocks.friedrich.tetris.color.GreenColorSchema;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.HashMap;

/**
 * https://stackoverflow.com/a/62507011
 */
public class ImagePreparer {

    private static final HashMap<String, BufferedImage> cache = new HashMap<>();

    private static String getFilePath(String pathname) {
        return ImagePreparer.class.getClassLoader().getResource(pathname).getFile();
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

    public static BufferedImage get(String pathname) {
        if (cache.containsKey(pathname)) {
            return cache.get(pathname);
        }
        try {
            BufferedImage image = read(pathname);
            image = scale(changeColorSchema(image), Tetris.SCALE);
            cache.put(pathname, image);
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * https://stackoverflow.com/a/4216635
     */
    public static BufferedImage scale(BufferedImage image, int scale) {
        System.out.println("Scaling image by " + scale);
        BufferedImage after = new BufferedImage(image.getWidth() * scale, image.getHeight() * scale,
                BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return scaleOp.filter(image, after);
    }

    /**
     * https://codereview.stackexchange.com/a/146611
     */
    public static BufferedImage changeColorSchema(BufferedImage image) {
        ColorSchema from = new GrayColorSchema();
        ColorSchema to = new GreenColorSchema();

        int w = image.getWidth();
        int h = image.getHeight();
        int[] rgb = image.getRGB(0, 0, w, h, null, 0, w);
        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] == from.white().getRGB()) {
                rgb[i] = to.white().getRGB();
            } else if (rgb[i] == from.light().getRGB()) {
                rgb[i] = to.light().getRGB();
            } else if (rgb[i] == from.dark().getRGB()) {
                rgb[i] = to.dark().getRGB();
            } else if (rgb[i] == from.black().getRGB()) {
                rgb[i] = to.black().getRGB();
            }
        }
        image.setRGB(0, 0, w, h, rgb, 0, w);
        return image;
    }

}
