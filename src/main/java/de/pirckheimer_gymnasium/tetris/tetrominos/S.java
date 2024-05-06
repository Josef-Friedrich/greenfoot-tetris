package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class S extends Tetromino
{
    public S(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "S", x, y);
        addBlock(1, "S", x + 1, y);
        addBlock(2, "S", x - 1, y - 1);
        addBlock(3, "S", x, y - 1);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        case 1:
        case 3:
            doBlockMotion(1, -2, 0);
            doBlockMotion(2, 0, 2);
            break;

        case 0:
        case 2:
            doBlockMotion(1, 2, 0);
            doBlockMotion(2, 0, -2);
            break;
        }
    }
}
