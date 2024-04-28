package rocks.friedrich.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.actor.Image;

public class TitleScene extends Scene
{
    public TitleScene()
    {
        Image image = new Image("images/Title-Screen.png", 16);
        add(image);
    }
}
