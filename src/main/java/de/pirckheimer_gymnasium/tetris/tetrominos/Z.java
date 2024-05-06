package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class Z extends Tetromino
{
    public Z(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "Z", x, y);
        addBlock(1, "Z", x - 1, y);
        addBlock(2, "Z", x, y - 1);
        addBlock(3, "Z", x + 1, y - 1);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 1:
        case 3:
            setBlockMotion(2, 0, 2);
            setBlockMotion(3, -2, 0);
            break;

        case 0:
        case 2:
            setBlockMotion(2, 0, -2);
            setBlockMotion(3, 2, 0);
            break;
        }
    }
}
