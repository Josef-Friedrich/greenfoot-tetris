package de.pirckheimer_gymnasium.tetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import rocks.friedrich.engine_omega.util.ImageUtil;

/**
 * Eine Spezialisierung von {@link Image}.
 *
 * Bereitet Bilder für die Verwendung in Tetris vor.
 */
public class Image extends rocks.friedrich.engine_omega.actor.Image
{
    /**
     * Das klassische Gameboy-Spiel hat ein Farbschema, das aus nur vier Farben
     * besteht.
     *
     * Wir verwenden als Farbnamen <em>weiß</em> ({@code white}), <em>hell</em>
     * ({@code light}), <em>dunkel</em> ({@code dark}) und <em>schwarz</em>
     * ({@code black}).
     */
    static String[] GRAY_COLOR_SCHEME = { "#ffffff", "#adadad", "#525252",
            "#000000", };

    static String[] GREEN_COLOR_SCHEME = { "#aaaa00", "#556633", "#335544",
            "#223322", };

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
            image = ImageUtil.scale(ImageUtil.replaceColors(image,
                    GRAY_COLOR_SCHEME, GREEN_COLOR_SCHEME), Tetris.SCALE);
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
