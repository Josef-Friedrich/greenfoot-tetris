package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.tetris.Tetris;

public class CopyrightScene extends BaseScene
{
    public CopyrightScene()
    {
        super("copyright");
    }

    public static void main(String[] args)
    {
        Tetris.start(new CopyrightScene());
    }
}
