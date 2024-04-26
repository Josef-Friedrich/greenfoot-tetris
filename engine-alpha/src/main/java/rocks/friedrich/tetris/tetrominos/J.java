package rocks.friedrich.tetris.tetrominos;

import ea.Scene;

public class J extends Tetromino{
    public J(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("J", x, y);
        blocks[1] = createBlock("J", x - 1, y);
        blocks[2] = createBlock("J", x + 1, y);
        blocks[3] = createBlock("J", x + 1, y - 1);
    }

}
