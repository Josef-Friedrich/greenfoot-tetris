package rocks.friedrich.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class S extends Tetromino {
    public S(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("S", x, y);
        blocks[1] = createBlock("S", x, y - 1);
        blocks[2] = createBlock("S", x, y - 2);
        blocks[3] = createBlock("S", x + 1, y);
    }

}
