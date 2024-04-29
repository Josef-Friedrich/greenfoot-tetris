package de.pirckheimer_gymnasium.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.Image;

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
