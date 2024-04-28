package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class Z extends Tetromino {
    public Z(Scene scene, int x, int y, boolean debug) {
        super(scene, x, y, debug);
        addBlock(0, "Z", x, y);
        addBlock(1, "Z", x - 1, y - 1);
        addBlock(2, "Z", x, y - 1);
        addBlock(3, "Z", x + 1, y - 1);
    }

}
