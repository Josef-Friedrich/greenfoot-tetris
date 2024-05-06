package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class I extends Tetromino
{
    public I(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "I", x, y);
        addBlock(1, "I", x - 1, y);
        addBlock(2, "I", x + 1, y);
        addBlock(3, "I", x + 2, y);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        case 0:
        case 2:
            doBlockMotion(0, 0, 0);
            doBlockMotion(1, -1, 1);
            doBlockMotion(2, 1, -1);
            doBlockMotion(3, 2, -2);
            break;

        case 1:
        case 3:
            doBlockMotion(0, 0, 0);
            doBlockMotion(1, 1, -1);
            doBlockMotion(2, -1, 1);
            doBlockMotion(3, -2, 2);
            break;
        }
    }
}
