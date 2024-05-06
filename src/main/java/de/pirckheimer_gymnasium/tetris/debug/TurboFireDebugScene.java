package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;

import java.awt.event.KeyEvent;

public class TurboFireDebugScene extends BaseScene
{
    public TurboFireDebugScene()
    {
        super(null);
        addTurboFire(KeyEvent.VK_RIGHT, 0.3f, () -> {
            System.out.println("right");
        });
        addTurboFire(KeyEvent.VK_LEFT, 0.3f, () -> {
            System.out.println("left");
        });
    }

    public static void main(String[] args)
    {
        Tetris.start(new TurboFireDebugScene());
    }
}
