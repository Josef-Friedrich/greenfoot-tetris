package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class L extends Tetromino
{
    public L(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "L", x, y);
        addBlock(1, "L", x - 1, y);
        addBlock(2, "L", x + 1, y);
        addBlock(3, "L", x - 1, y - 1);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        // 0 -> 1
        case 1:
            // xxx 31x 31x
            // 102 102 x0x
            // 3xx 32x x2x
            moveBlock(1, 1, 1);
            moveBlock(2, -1, -1);
            moveBlock(3, 0, 2);
            break;

        // 1 -> 2
        case 2:
            // 31x 313 xx3
            // x0x 201 201
            // x2x x2x xxx
            moveBlock(1, 1, -1);
            moveBlock(2, -1, 1);
            moveBlock(3, 2, 0);
            break;

        // 2 -> 3
        case 3:
            moveBlock(1, -1, -1);
            moveBlock(2, 1, 1);
            moveBlock(3, 0, -2);
            break;

        // 3 -> 0
        case 0:
            moveBlock(1, -1, 1);
            moveBlock(2, 1, -1);
            moveBlock(3, -2, 0);
            break;
        }
    }
}
