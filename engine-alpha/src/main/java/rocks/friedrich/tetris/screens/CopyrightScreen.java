package rocks.friedrich.tetris.screens;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.actor.Image;

public class CopyrightScreen extends Scene
{
    public CopyrightScreen()
    {
        Image image = new Image("images/First-Screen.png", 32);
        image.setPosition(0, 0);
        add(image);
        getCamera().setPostion(10, 9);
    }
}
