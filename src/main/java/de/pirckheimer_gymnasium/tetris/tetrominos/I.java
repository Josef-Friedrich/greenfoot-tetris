package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class I extends Tetromino
{
    public I(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "I_center", x, y);
        addBlock(1, "I_left", x - 1, y);
        addBlock(2, "I_center", x + 1, y);
        addBlock(3, "I_right", x + 2, y);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 0:
        case 2:
            setBlockMotion(1, -1, 1);
            setBlockMotion(2, 1, -1);
            setBlockMotion(3, 2, -2);
            for (int i = 0; i < 4; i++)
            {
                blocks[i].rotateClockwise();
            }
            break;

        case 1:
        case 3:
            setBlockMotion(1, 1, -1);
            setBlockMotion(2, -1, 1);
            setBlockMotion(3, -2, 2);
            for (int i = 0; i < 4; i++)
            {
                blocks[i].rotateCounterClockwise();
            }
            break;
        }
    }
}
