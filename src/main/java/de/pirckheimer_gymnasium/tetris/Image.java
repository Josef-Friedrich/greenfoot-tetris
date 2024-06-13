package de.pirckheimer_gymnasium.tetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import de.pirckheimer_gymnasium.engine_pi.util.ImageUtil;

/**
 * Eine Spezialisierung von {@link Image}.
 *
 * Bereitet Bilder für die Verwendung in Tetris vor.
 */
public class Image extends de.pirckheimer_gymnasium.engine_pi.actor.Image
{
    public Image(String pathname)
    {
        super(Image.get(pathname), Tetris.SCALE * Tetris.BLOCK_SIZE);
    }

    private static final HashMap<String, BufferedImage> cache = new HashMap<>();

    private static String getFilePath(String pathname)
    {
        return Image.class.getClassLoader().getResource(pathname).getFile();
    }

    private static File getFile(String pathname)
    {
        return new File(getFilePath(pathname));
    }

    public static BufferedImage read(String pathname) throws IOException
    {
        return ImageIO.read(getFile(pathname));
    }

    public static void write(BufferedImage image, String pathname)
            throws IOException
    {
        ImageIO.write(image, "png", new File(pathname));
    }

    /**
     * Gibt ein vergrößertes und eingefärbtes Bild zurück.
     *
     * Die Ausgangsbilder haben als Farben vier verschiedene Grautöne bzw. zwei
     * Grautöne und schwarz und weiß. Mit Hilfe dieser Methode ist es möglich,
     * die Bilder z. B. grünlich einzufärben, sodass sie dem klassischen
     * Gameboy-Farben ähneln. So müssen nicht für ein bestimmtes Farbschema
     * entscheiden und dann viele Bilddateien erstellen, die dann wieder
     * geändert werden müssten, wenn wir ein anderes Fahrschema nutzen wollen.
     *
     * Dieser Methode ist außerdem ein Zwischenspeicher (Cache) vorgeschaltet.
     * Wird zweimal das gleiche Bild angefordert, wird das Bild beim zweiten Mal
     * aus dem Cache geladen und nicht neu berechnet.
     *
     * @param pathname Der relative Pfad zu {@code src/main/resources}.
     *
     * @return Das vergrößerte und eingefärbtes Bild.
     */
    public static BufferedImage get(String pathname)
    {
        if (cache.containsKey(pathname))
        {
            return cache.get(pathname);
        }
        try
        {
            BufferedImage image = read(pathname);
            image = ImageUtil.scale(
                    ImageUtil.replaceColors(image,
                            Tetris.COLOR_SCHEME_GRAY.getColors(),
                            Tetris.COLOR_SCHEME_GREEN.getColors()),
                    Tetris.SCALE);
            cache.put(pathname, image);
            return image;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
