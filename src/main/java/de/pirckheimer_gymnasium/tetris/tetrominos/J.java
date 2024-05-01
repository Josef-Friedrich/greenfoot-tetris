package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class J extends Tetromino
{
    public J(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "J", x, y);
        addBlock(1, "J", x - 1, y);
        addBlock(2, "J", x + 1, y);
        addBlock(3, "J", x + 1, y - 1);
    }

    public void rotate()
    {
        super.rotate();
        switch (rotation)
        {
        // 0 -> 1
        case 1:
            blocks[1].moveBy(1, 1);
            blocks[2].moveBy(-1, -1);
            blocks[3].moveBy(-2, 0);
            break;

        // 1 -> 2
        case 2:
            blocks[1].moveBy(1, -1);
            blocks[2].moveBy(-1, 1);
            blocks[3].moveBy(0, 2);
            break;

        // 2 -> 3
        case 3:
            blocks[1].moveBy(-1, -1);
            blocks[2].moveBy(1, 1);
            blocks[3].moveBy(2, 0);
            break;

        // 3 -> 0
        case 0:
            blocks[1].moveBy(-1, 1);
            blocks[2].moveBy(1, -1);
            blocks[3].moveBy(0, -2);
            break;
        }
    }
}
