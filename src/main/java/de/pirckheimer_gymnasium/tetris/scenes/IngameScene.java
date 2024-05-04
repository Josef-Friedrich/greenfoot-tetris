package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.Random;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.BlockGrid;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.event.KeyListener;

public class IngameScene extends BaseScene implements KeyListener
{
    private BlockGrid grid;

    private static Random random = new Random();

    private int nextTetromino;

    private Tetromino tetromino;

    public IngameScene()
    {
        super("ingame");
        // Das I-Tetromino ragt einen Block über das sichtbare Spielfeld hinaus,
        // wenn es in der Startposition gedreht wird.
        grid = new BlockGrid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        setNextTetrominoNo();
        createTetromino();
        repeat(1, () -> {
            if (!tetromino.moveDown())
            {
                createTetromino();
            }
        });
    }

    private void setNextTetrominoNo()
    {
        nextTetromino = random.nextInt(7);
    }

    private void createTetromino()
    {
        Tetromino.create(this, grid, nextTetromino, 3, 0, Tetris.DEBUG);
        setNextTetrominoNo();
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_LEFT:
            tetromino.moveLeft();
            break;

        case KeyEvent.VK_RIGHT:
            tetromino.moveRight();
            break;
        // case KeyEvent.VK_DOWN:
        // tetromino.moveDown();
        // break;

        case KeyEvent.VK_SPACE:
            tetromino.rotate();
            break;
        }
        if (Tetris.DEBUG)
        {
            grid.print();
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new IngameScene());
    }
}
