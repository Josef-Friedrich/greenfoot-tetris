package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Tetris;
import rocks.friedrich.engine_omega.event.KeyListener;

/**
 * Das ist der erste Bildschirm, der beim Starten des Spiels angezeigt wird.
 */
public class CopyrightScene extends BaseScene implements KeyListener
{
    public CopyrightScene()
    {
        super("copyright");
        delay(3, () -> startTitleScene());
    }

    public void startTitleScene()
    {
        Tetris.start(new TitleScene());
    }

    /**
     * Wenn eine beliebige Taste gedrückt wird, wird zum nächsten Bildschirm,
     * der Titelszene, gesprungen.
     */
    public void onKeyDown(KeyEvent keyEvent)
    {
        startTitleScene();
    }

    public static void main(String[] args)
    {
        Tetris.start(new CopyrightScene());
    }
}
