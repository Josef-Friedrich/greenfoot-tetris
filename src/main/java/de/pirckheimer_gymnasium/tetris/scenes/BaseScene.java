package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Scene;

/**
 * Die Basisszene setzt ein Hintergrundbild an die Position (-2,0) und
 * fokussiert dieses Bild.
 */
public class BaseScene extends Scene
{
    /**
     * Das Hintergrundbild
     */
    protected Image background;

    protected TurboFireStarter turboFire;

    public BaseScene(String imageFilename)
    {
        if (imageFilename != null)
        {
            background = new Image("fullscreen/" + imageFilename + ".png");
            // Wir setzten alle Hintergrundbilder auf die Position (-2, 0),
            // damit
            // im Hauptspiel die linke untere Ecke des Blockrasters an der
            // Position
            // (0,0) steht.
            // Dadurch stimmen die Engine-Omega-Koordination mit den Indexen im
            // zweidimensionen Block-Array überein.
            background.setPosition(-2, 0);
            getCamera().setFocus(background);
            add(background);
        }
        turboFire = new TurboFireStarter(this);
        addKeyListener(turboFire);
    }

    public void addTurboFire(int keyCode, float interval, Runnable runnable)
    {
        turboFire.addTask(keyCode, interval, runnable);
    }
}
