package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.tetris.Image;
import de.pirckheimer_gymnasium.tetris.Tetris;
import rocks.friedrich.engine_omega.Scene;

public class IImageDebugScene extends Scene
{
    public IImageDebugScene()
    {
        Image image = new Image("blocks/I_left.png");
        add(image);

        Image i2 = new Image("blocks/I_left.png");
        i2.rotateBy(90);
        i2.setPosition(2, 0);
        add(i2);
    }

    public static void main(String[] args)
    {
        Tetris.start(new IImageDebugScene(), true);
    }
}
