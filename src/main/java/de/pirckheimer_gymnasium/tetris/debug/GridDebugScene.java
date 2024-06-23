/*
 * Copyright (c) 2024 Josef Friedrich and contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.engine_pi.Game;
import de.pirckheimer_gymnasium.engine_pi.Vector;
import de.pirckheimer_gymnasium.engine_pi.actor.Rectangle;
import de.pirckheimer_gymnasium.engine_pi.event.FrameUpdateListener;
import de.pirckheimer_gymnasium.engine_pi.event.KeyStrokeListener;
import de.pirckheimer_gymnasium.engine_pi.event.MouseButton;
import de.pirckheimer_gymnasium.engine_pi.event.MouseClickListener;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.scenes.BaseScene;
import de.pirckheimer_gymnasium.tetris.tetrominos.FilledRowRange;
import de.pirckheimer_gymnasium.tetris.tetrominos.Grid;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;

/**
 * @author Josef Friedrich
 */
public class GridDebugScene extends BaseScene
        implements KeyStrokeListener, FrameUpdateListener, MouseClickListener
{
    private Grid grid;

    private final Rectangle ROW_OVERLAY;

    private FilledRowRange range;

    private final Rectangle RANGE_OVERLAY;

    public GridDebugScene()
    {
        super("ingame");
        grid = new Grid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        ROW_OVERLAY = addOverlayRectangle("green");
        RANGE_OVERLAY = addOverlayRectangle("blue");
        fillGrid3();
    }

    private Rectangle addOverlayRectangle(String color)
    {
        Rectangle rectangle = new Rectangle(10, 1);
        rectangle.setColor(color);
        rectangle.setOpacity(0.7);
        rectangle.setLayerPosition(2);
        add(rectangle);
        return rectangle;
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

    private void L(int rotation, int x, int y)
    {
        createTetromino("L", rotation, x, y);
    }

    private void J(int rotation, int x, int y)
    {
        createTetromino("J", rotation, x, y);
    }

    private void I(int rotation, int x, int y)
    {
        createTetromino("I", rotation, x, y);
    }

    private void O(int rotation, int x, int y)
    {
        createTetromino("O", rotation, x, y);
    }

    private void Z(int rotation, int x, int y)
    {
        createTetromino("Z", rotation, x, y);
    }

    private void S(int rotation, int x, int y)
    {
        createTetromino("S", rotation, x, y);
    }

    private void T(int rotation, int x, int y)
    {
        createTetromino("T", rotation, x, y);
    }

    private void fillGrid1()
    {
        O(0, 0, 1);
        O(0, 2, 1);
        O(0, 4, 1);
        O(0, 6, 1);
        O(0, 8, 1);
        I(0, 1, 2);
    }

    private void fillGrid2()
    {
        T(2, 1, 0);
    }

    /**
     * https://www.retroplace.com/de/spiele/174256--tetris
     */
    private void fillGrid3()
    {
        T(2, 4, 0);
        S(0, 2, 1);
        S(1, 6, 1);
        J(1, 9, 1);
        Z(1, 8, 1);
        T(3, 1, 2);
        Z(0, 3, 3);
        S(0, 7, 3);
        L(2, 5, 3);
        L(2, 4, 4);
        I(1, 9, 4);
        J(1, 8, 5);
        O(0, 6, 6);
        Z(1, 3, 5);
        T(3, 4, 6);
        T(2, 6, 7);
        O(0, 8, 8);
        I(1, 1, 5);
        I(1, 2, 7);
        // nicht im Screenshot der Vorlage
        I(1, 0, 1);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_ENTER:
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

        case KeyEvent.VK_3:
            grid.clear();
            fillGrid3();
            break;
        }
    }

    @Override
    public void onFrameUpdate(double pastTime)
    {
        Vector position = Game.getMousePositionInCurrentScene();
        ROW_OVERLAY.setY((int) position.getY());
        range = grid.getFilledRowRange();
        if (range != null)
        {
            RANGE_OVERLAY.setVisible(true);
            RANGE_OVERLAY.setHeight(range.getRowCount());
            RANGE_OVERLAY.setY(range.getFrom());
        }
        else
        {
            RANGE_OVERLAY.setVisible(false);
        }
    }

    @Override
    public void onMouseDown(Vector position, MouseButton button)
    {
        if (button == MouseButton.LEFT)
        {
            grid.clearRow((int) position.getY());
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new GridDebugScene());
    }
}
