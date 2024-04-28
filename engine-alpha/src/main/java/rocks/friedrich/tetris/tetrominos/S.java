package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class S extends Tetromino
{
    public S(Scene scene, int x, int y, boolean debug)
    {
        super(scene, x, y, debug);
        addBlock(0, "S", x, y);
        addBlock(1, "S", x, y - 1);
        addBlock(2, "S", x, y - 2);
        addBlock(3, "S", x + 1, y);
    }
}
