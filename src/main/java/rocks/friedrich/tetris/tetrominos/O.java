package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class O extends Tetromino
{
    public O(Scene scene, int x, int y, boolean debug)
    {
        super(scene, x, y, debug);
        addBlock(0, "O", x, y);
        addBlock(1, "O", x + 1, y);
        addBlock(2, "O", x, y + 1);
        addBlock(3, "O", x + 1, y + 1);
    }
}
