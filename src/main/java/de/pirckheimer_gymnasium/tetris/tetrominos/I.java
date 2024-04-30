package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class I extends Tetromino
{
    public I(Scene scene, int x, int y, boolean debug)
    {
        super(scene, x, y, debug);
        addBlock(0, "I_center", x, y);
        addBlock(1, "I_left", x - 1, y);
        addBlock(2, "I_center", x + 1, y);
        addBlock(3, "I_right", x + 2, y);
    }

    public void rotate()
    {
        super.rotate();
        switch (rotation)
        {
        case 0:
        case 2:
            blocks[1].moveBy(-1, 1);
            blocks[2].moveBy(1, -1);
            blocks[3].moveBy(2, -2);
            for (int i = 0; i < 4; i++)
            {
                blocks[i].rotateClockwise();
            }
            break;

        case 1:
        case 3:
            blocks[1].moveBy(1, -1);
            blocks[2].moveBy(-1, 1);
            blocks[3].moveBy(-2, 2);
            for (int i = 0; i < 4; i++)
            {
                blocks[i].rotateCounterClockwise();
            }
            break;
        }
    }
}
