package rocks.friedrich.tetris.tetrominos;

import ea.Scene;

public class I extends Tetromino {
    public I(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("T", x, y);
        blocks[1] = createBlock("T", x - 1, y);
        blocks[2] = createBlock("T", x + 1, y);
        blocks[3] = createBlock("T", x + 2, y);
    }

    public void rotate() {
        super.rotate();

        switch (rotation) {
            case 0:
            case 2:
                blocks[1].moveBy(-1, 1);
                blocks[2].moveBy(1, -1);
                blocks[3].moveBy(2, -2);
                break;

            case 1:
            case 3:
                blocks[1].moveBy(1, -1);
                blocks[2].moveBy(-1, 1);
                blocks[3].moveBy(-2, 2);
                break;

        }

    }
}
