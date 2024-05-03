package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.Scene;

public class TetrominoWithoutGridScene extends Scene
{
    public TetrominoWithoutGridScene()
    {
        Tetromino.create(this, null, "L", 3, -3, false);
    }

    public static void main(String[] args)
    {
        Tetris.start(new TetrominoWithoutGridScene());
    }
}
