package rocks.friedrich.tetris.screens;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.actor.Image;

public class TitleScreen extends Scene
{
    public TitleScreen()
    {
        Image image = new Image("images/Title-Screen.png", 16);
        add(image);
    }
}
