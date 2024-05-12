package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class IDeluxe extends Tetromino
{
    public IDeluxe(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, "I", x, y);
        // addBlock(0, "I_h_center", "I_v_center", x, y);
        // addBlock(1, "I_h_left", "I_v_bottom", x - 1, y);
        // addBlock(2, "I_h_center", "I_v_center", x + 1, y);
        // addBlock(3, "I_h_right", "I_v_top", x + 2, y);
    }

    protected void doRotation()
    {
        switch (rotation)
        {
        case 0:
        case 2:
            moveBlock(0, 0, 0);
            moveBlock(1, -1, 1);
            moveBlock(2, 1, -1);
            moveBlock(3, 2, -2);
            break;

        case 1:
        case 3:
            moveBlock(0, 0, 0);
            moveBlock(1, 1, -1);
            moveBlock(2, -1, 1);
            moveBlock(3, -2, 2);
            break;
        }
    }
}
