package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

public class RandomTetrominoScene extends Scene implements KeyListener
{
    private Tetromino tetromino;

    public RandomTetrominoScene()
    {
        createTetromino();
    }

    private void createTetromino()
    {
        if (tetromino != null)
        {
            tetromino.remove();
        }
        tetromino = Tetromino.createRandom(this, 3, -3);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        createTetromino();
    }

    public static void main(String[] args)
    {
        Tetris.start(new RandomTetrominoScene());
    }
}
