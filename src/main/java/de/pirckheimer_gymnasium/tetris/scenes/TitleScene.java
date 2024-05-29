package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.tetris.Tetris;

public class TitleScene extends BaseScene
{
    public TitleScene()
    {
        super("title");
        delay(4, () -> {
            startIngameScene();
        });
    }

    public void startIngameScene()
    {
        Tetris.start(new IngameScene());
    }

    public static void main(String[] args)
    {
        Tetris.start(new TitleScene());
    }
}
