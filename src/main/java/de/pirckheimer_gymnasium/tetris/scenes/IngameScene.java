package de.pirckheimer_gymnasium.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import de.pirckheimer_gymnasium.tetris.Image;
import de.pirckheimer_gymnasium.tetris.Tetris;

public class IngameScene extends Scene
{
    public IngameScene()
    {
        Image image = new Image("fullscreen/ingame.png");
        getCamera().setFocus(image);
        add(image);
    }

    public static void main(String[] args)
    {
        Tetris.start(new IngameScene());
    }
}
