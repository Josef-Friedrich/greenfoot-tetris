package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;
import de.pirckheimer_gymnasium.tetris.scenes.PressedKeyRepeater;

import java.awt.event.KeyEvent;

public class PressedKeyRepeaterScene extends BaseScene
{
    PressedKeyRepeater keyRepeater;

    public PressedKeyRepeaterScene()
    {
        super(null);
        keyRepeater = new PressedKeyRepeater(this);
        keyRepeater.addTask(KeyEvent.VK_RIGHT, () -> {
            System.out.println("right");
        });
        keyRepeater.addTask(KeyEvent.VK_LEFT, () -> {
            System.out.println("left");
        });
    }

    public static void main(String[] args)
    {
        Tetris.start(new PressedKeyRepeaterScene());
    }
}
