package de.pirckheimer_gymnasium.tetris.debug;

import de.pirckheimer_gymnasium.engine_pi.Scene;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;

public class TetrominoWithoutGridScene extends Scene
{
    public TetrominoWithoutGridScene()
    {
        Tetromino.create(this, null, "L", 3, -3);
    }

    public static void main(String[] args)
    {
        Tetris.start(new TetrominoWithoutGridScene());
    }
}
