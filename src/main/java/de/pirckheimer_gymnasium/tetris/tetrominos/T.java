package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class T extends Tetromino
{
    public T(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, "T", x, y);
        addBlock(0, x, y);
        addBlock(1, x - 1, y);
        addBlock(2, x + 1, y);
        addBlock(3, x, y - 1);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        case 0:
            moveBlock(1, -1, 1);
            moveBlock(2, 1, -1);
            moveBlock(3, -1, -1);
            break;

        case 1:
            moveBlock(2, -1, 1);
            break;

        case 2:
            moveBlock(3, 1, 1);
            break;

        case 3:
            moveBlock(1, 1, -1);
            break;
        }
    }
}
