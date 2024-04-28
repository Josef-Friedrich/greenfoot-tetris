package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class L extends Tetromino {
    public L(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("L", x, y);
        blocks[1] = createBlock("L", x - 1, y);
        blocks[2] = createBlock("L", x + 1, y);
        blocks[3] = createBlock("L", x - 1, y - 1);
    }

}
