package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;

import java.awt.event.KeyEvent;

public class PressedKeyRepeaterScene extends BaseScene
{
    public PressedKeyRepeaterScene()
    {
        super(null);
        onKeyPressed(KeyEvent.VK_RIGHT, 0.3, () -> {
            System.out.println("right");
        }, 1.0);
        onKeyPressed(KeyEvent.VK_LEFT, 0.3, () -> {
            System.out.println("left");
        }, 1.0);
    }

    public static void main(String[] args)
    {
        Tetris.start(new PressedKeyRepeaterScene());
    }
}
