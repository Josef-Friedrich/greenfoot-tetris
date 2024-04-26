package rocks.friedrich.tetris.tetrominos;

import ea.Scene;

public class Z extends Tetromino {
    public Z(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("Z", x, y);
        blocks[1] = createBlock("Z", x - 1, y - 1);
        blocks[2] = createBlock("Z", x, y - 1);
        blocks[3] = createBlock("Z", x + 1, y - 1);
    }

}
