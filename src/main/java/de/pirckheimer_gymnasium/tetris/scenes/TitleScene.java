package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.tetris.Tetris;

public class TitleScene extends BaseScene
{
    public TitleScene()
    {
        super("title");
    }

    public static void main(String[] args)
    {
        Tetris.start(new TitleScene());
    }
}
