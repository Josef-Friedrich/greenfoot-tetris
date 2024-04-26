package rocks.friedrich.tetris.tetrominos;

import ea.Scene;

public class O extends Tetromino {
    public O(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("O", x, y);
        blocks[1] = createBlock("O", x + 1, y);
        blocks[2] = createBlock("O", x, y + 1);
        blocks[3] = createBlock("O", x + 1, y + 1);
    }

}
