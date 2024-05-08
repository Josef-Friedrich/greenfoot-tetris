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
        fillGrid1();
    }

    private void createTetromino(String name, int rotation, int x, int y)
    {
        Tetromino tetromino = Tetromino.create(this, null, name, x, y);
        for (int i = 0; i < rotation; i++)
        {
            tetromino.rotate();
        }
        tetromino.addGrid(grid);
    }

    private void fillGrid1()
    {
        createTetromino("O", 0, 0, 1);
        createTetromino("O", 0, 2, 1);
        createTetromino("O", 0, 4, 1);
        createTetromino("O", 0, 6, 1);
        createTetromino("O", 0, 8, 1);
        createTetromino("I", 0, 1, 2);
    }

    private void fillGrid2()
    {
        createTetromino("T", 2, 1, 0);
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

        case KeyEvent.VK_1:
            grid.clear();
            fillGrid1();
            break;

        case KeyEvent.VK_2:
            grid.clear();
            fillGrid2();
            break;
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new GridDebugScene());
    }
}
