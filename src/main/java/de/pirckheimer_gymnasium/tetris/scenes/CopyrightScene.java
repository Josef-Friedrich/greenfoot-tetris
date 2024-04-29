package de.pirckheimer_gymnasium.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import de.pirckheimer_gymnasium.tetris.Image;
import de.pirckheimer_gymnasium.tetris.Tetris;

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
