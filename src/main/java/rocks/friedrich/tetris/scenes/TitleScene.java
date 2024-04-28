package rocks.friedrich.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.Tetris;
import rocks.friedrich.tetris.Image;

public class TitleScene extends Scene
{
    public TitleScene()
    {
        Image image = new Image("fullscreen/title.png");
        getCamera().setFocus(image);
        add(image);
    }

    public static void main(String[] args)
    {
        Tetris.start(new TitleScene());
    }
}
