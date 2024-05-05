package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class I extends Tetromino
{
    public I(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "I", x, y);
        addBlock(1, "I", x - 1, y);
        addBlock(2, "I", x + 1, y);
        addBlock(3, "I", x + 2, y);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 0:
        case 2:
            setBlockMotion(0, 0, 0);
            setBlockMotion(1, -1, 1);
            setBlockMotion(2, 1, -1);
            setBlockMotion(3, 2, -2);
            break;

        case 1:
        case 3:
            setBlockMotion(0, 0, 0);
            setBlockMotion(1, 1, -1);
            setBlockMotion(2, -1, 1);
            setBlockMotion(3, -2, 2);
            break;
        }
    }
}
