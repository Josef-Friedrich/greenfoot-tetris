package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

class O extends Tetromino
{
    public O(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "O", x, y);
        addBlock(1, "O", x + 1, y);
        addBlock(2, "O", x, y - 1);
        addBlock(3, "O", x + 1, y - 1);
    }

    protected void doRotation()
    {
        // keine Rotation notwendig bei O
    }
}
