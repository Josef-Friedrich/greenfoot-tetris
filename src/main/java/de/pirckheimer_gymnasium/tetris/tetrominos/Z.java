package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class Z extends Tetromino
{
    public Z(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "Z", x, y);
        addBlock(1, "Z", x - 1, y);
        addBlock(2, "Z", x, y - 1);
        addBlock(3, "Z", x + 1, y - 1);
    }

    public void rotate()
    {
        super.rotate();
        switch (rotation)
        {
        case 1:
        case 3:
            blocks[2].moveBy(0, 2);
            blocks[3].moveBy(-2, 0);
            break;

        case 0:
        case 2:
            blocks[2].moveBy(0, -2);
            blocks[3].moveBy(2, 0);
            break;
        }
    }
}
