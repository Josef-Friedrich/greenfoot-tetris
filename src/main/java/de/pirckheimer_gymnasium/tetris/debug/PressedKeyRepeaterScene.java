package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;
import de.pirckheimer_gymnasium.tetris.scenes.PressedKeyRepeater;
import rocks.friedrich.engine_omega.Scene;

public class PressedKeyRepeaterScene extends BaseScene
{
    PressedKeyRepeater<Scene> keyRepeater;

    public PressedKeyRepeaterScene()
    {
        super(null);
        keyRepeater = new PressedKeyRepeater<Scene>(this);
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
