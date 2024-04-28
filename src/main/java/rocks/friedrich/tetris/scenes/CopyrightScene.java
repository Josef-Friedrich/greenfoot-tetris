package rocks.friedrich.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.Image;
import rocks.friedrich.tetris.Tetris;

public class CopyrightScene extends Scene
{
    public CopyrightScene()
    {
        Image image = new Image("fullscreen/copyright.png");
        getCamera().setFocus(image);
        add(image);
    }

    public static void main(String[] args)
    {
        Tetris.start(new CopyrightScene());
    }
}
