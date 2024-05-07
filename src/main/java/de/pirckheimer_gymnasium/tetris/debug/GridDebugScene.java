package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;
import de.pirckheimer_gymnasium.tetris.tetrominos.Grid;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.event.KeyListener;

public class GridDebugScene extends BaseScene implements KeyListener
{
    private Grid grid;

    public GridDebugScene()
    {
        super("ingame");
        grid = new Grid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        createTetromino("O", 0, 1);
        createTetromino("O", 2, 1);
        createTetromino("O", 4, 1);
        createTetromino("O", 6, 1);
        createTetromino("O", 8, 1);
        createTetromino("I", 1, 2);
    }

    private void createTetromino(String name, int x, int y)
    {
        Tetromino.create(this, grid, name, x, y);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_ENTER:
            var range = grid.getFilledRowRange();
            grid.print();
            if (range != null)
            {
                grid.removeFilledRowRange(range);
                grid.triggerLandslide(range);
                grid.print();
            }
            break;
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new GridDebugScene());
    }
}
