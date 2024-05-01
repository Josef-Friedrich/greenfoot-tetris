package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class T extends Tetromino
{
    public T(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "T", x, y);
        addBlock(1, "T", x - 1, y);
        addBlock(2, "T", x + 1, y);
        addBlock(3, "T", x, y - 1);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        case 0:
            blocks[1].moveBy(-1, 1);
            blocks[2].moveBy(1, -1);
            blocks[3].moveBy(-1, -1);
            break;

        case 1:
            blocks[2].moveBy(-1, 1);
            break;

        case 2:
            blocks[3].moveBy(1, 1);
            break;

        case 3:
            blocks[1].moveBy(1, -1);
            break;
        }
    }
}
