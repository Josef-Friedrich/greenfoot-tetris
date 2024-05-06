package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class T extends Tetromino
{
    public T(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "T", x, y);
        addBlock(1, "T", x - 1, y);
        addBlock(2, "T", x + 1, y);
        addBlock(3, "T", x, y - 1);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 0:
            setBlockMotion(1, -1, 1);
            setBlockMotion(2, 1, -1);
            setBlockMotion(3, -1, -1);
            break;

        case 1:
            setBlockMotion(2, -1, 1);
            break;

        case 2:
            setBlockMotion(3, 1, 1);
            break;

        case 3:
            setBlockMotion(1, 1, -1);
            break;
        }
    }
}
