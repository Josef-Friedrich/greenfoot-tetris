package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class O extends Tetromino
{
    public O(Scene scene, Grid grid, int x, int y)
    {
        super(scene, grid, x, y);
        addBlock(0, "O", x, y);
        addBlock(1, "O", x + 1, y);
        addBlock(2, "O", x, y - 1);
        addBlock(3, "O", x + 1, y - 1);
    }

    protected void setRotation()
    {
        // keine Rotation notwendig bei O
    }
}
