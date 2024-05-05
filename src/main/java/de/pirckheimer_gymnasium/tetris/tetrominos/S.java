package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class S extends Tetromino
{
    public S(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "S", x, y);
        addBlock(1, "S", x + 1, y);
        addBlock(2, "S", x - 1, y - 1);
        addBlock(3, "S", x, y - 1);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 1:
        case 3:
            setBlockMotion(1, -2, 0);
            setBlockMotion(2, 0, 2);
            break;

        case 0:
        case 2:
            setBlockMotion(1, 2, 0);
            setBlockMotion(2, 0, -2);
            break;
        }
    }
}
