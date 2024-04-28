package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class J extends Tetromino{
    public J(Scene scene, int x, int y, boolean debug) {
        super(scene, x, y, debug);
        addBlock(0, "J", x, y);
        addBlock(1, "J", x - 1, y);
        addBlock(2, "J", x + 1, y);
        addBlock(3, "J", x + 1, y - 1);
    }

}
