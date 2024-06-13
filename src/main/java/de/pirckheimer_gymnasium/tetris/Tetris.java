package de.pirckheimer_gymnasium.tetris;

import java.awt.Color;

import de.pirckheimer_gymnasium.tetris.scenes.CopyrightScene;
import de.pirckheimer_gymnasium.engine_pi.Game;
import de.pirckheimer_gymnasium.engine_pi.Scene;

public class Tetris
{
    /**
     * Die Größe eines Blocks in Pixeln. In dem klassischen Gameboy-Tetris hat
     * ein Block die Größe {@code 8x8}, die Blockgröße beträgt also {@code 8}
     * Pixel.
     */
    public static final int BLOCK_SIZE = 8;

    /**
     * Die Breite des Spielfelds in Blöcken. In dem klassischen Gameboy-Tetris
     * passen 20 Blöcken in die Breite.
     */
    public static final int WIDTH = 20;

    /**
     * Die Höhe des Spielfelds in Blöcken. In dem klassischen Gameboy-Tetris
     * passen 18 Blöcken in die Höhe.
     */
    public static final int HEIGHT = 18;

    /**
     * Die Skalierung des Spiels. Wird zum Beispiel 4 eingestellt, so wird ein
     * {@code 8x8} Block auf {@code 32x32} vergrößert.omega
     */
    public static final int SCALE = 4;

    /**
     * Das Spielfeld hat rechts einen Abstand zum Bildschirmrand von 8 Blöcken.
     */
    public static final int GRID_WIDTH = 10;

    public static final Color COLOR_WHITE = null;

    public static final Color COLOR_LIGHT = null;

    public static final Color COLOR_DARK = null;

    public static final Color COLOR_BLACK = null;

    public static final ColorScheme COLOR_SCHEME_GRAY = new ColorScheme(
            "#ffffff", "#adadad", "#525252", "#000000");

    public static final ColorScheme COLOR_SCHEME_GREEN = new ColorScheme(
            "#aaaa00", "#556633", "#335544", "#223322");

    /**
     * Aktivert und deaktiviert den Debug-Modus der Engine-Omega und des Spiels
     * Tetris.
     *
     * Die Methode ist eine Hüll-Methode um {@link Game#setDebug(boolean)}.
     *
     * @param value ist dieser Wert true, wird Tetris ab sofort im Debug-Modus
     *              ausgeführt.
     */
    public static void setDebug(boolean value)
    {
        Game.setDebug(value);
    }

    /**
     * Startet das Spiel mit der angegebenen Szene und bietet darüberhinaus die
     * Möglichkeit an, den Debug-Modus zu aktivieren oder zu deaktivieren.
     *
     * @param scene Die Szene, mit der das Spiel gestartet werden soll.
     */
    public static void start(Scene scene, boolean debug)
    {
        setDebug(debug);
        start(scene);
    }

    /**
     * Startet das Spiel mit der angegebenen Szene.
     *
     * @param scene Die Szene, mit der das Spiel gestartet werden soll.
     */
    public static void start(Scene scene)
    {
        scene.getCamera().setMeter(Tetris.SCALE * Tetris.BLOCK_SIZE);
        if (Game.isRunning())
        {
            Game.transitionToScene(scene);
        }
        else
        {
            Game.start(BLOCK_SIZE * WIDTH * SCALE, BLOCK_SIZE * HEIGHT * SCALE,
                    scene);
        }
    }

    /**
     * Startet das Spiel mit der {@link CopyrightScene}.
     */
    public static void start()
    {
        start(new CopyrightScene());
    }

    public static void main(String[] args)
    {
        Tetris.start();
    }
}
