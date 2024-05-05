package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class I extends Tetromino
{
    public I(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "I_h_center", "I_v_center", x, y);
        addBlock(1, "I_h_left", "I_v_bottom", x - 1, y);
        addBlock(2, "I_h_center", "I_v_center", x + 1, y);
        addBlock(3, "I_h_right", "I_v_top", x + 2, y);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 0:
        case 2:
            setBlockMotion(0, 0, 0, true);
            setBlockMotion(1, -1, 1, true);
            setBlockMotion(2, 1, -1, true);
            setBlockMotion(3, 2, -2, true);
            break;

        case 1:
        case 3:
            setBlockMotion(0, 0, 0, true);
            setBlockMotion(1, 1, -1, true);
            setBlockMotion(2, -1, 1, true);
            setBlockMotion(3, -2, 2, true);
            break;
        }
    }
}
