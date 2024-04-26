package rocks.friedrich.tetris.tetrominos;

import ea.Scene;

public class T extends Tetromino {

    public T(Scene scene, int x, int y) {
        super(scene, x, y);
        blocks[0] = createBlock("T", x, y);
        blocks[1] = createBlock("T", x - 1, y);
        blocks[2] = createBlock("T", x + 1, y);
        blocks[3] = createBlock("T", x, y - 1);
    }

    public void rotate() {
        super.rotate();

        switch (rotation) {
            case 0:
                blocks[1].moveBy(-1, 1);
                blocks[2].moveBy(1, -1);
                blocks[3].moveBy(-1, -1);
                break;

            case 1:
                blocks[2].moveBy(-1, 1);
                break;

            case 2:
                blocks[3].moveBy(1, 1);
                break;

            case 3:
                blocks[1].moveBy(1, -1);
                break;
        }

    }

}
