package rocks.friedrich.tetris.blocks;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.utils.ImageActor;

public class Block {

    private ImageActor image;

    private Scene scene;

    public Block(Scene scene, String blockName, int x, int y) {
        this.scene = scene;
        image = new ImageActor("images/blocks/Block-" + blockName + ".png");
        image.setPosition(x, y);
        scene.add(image);
    }

    public void moveLeft() {
        image.moveBy(-1, 0);
    }

    public void moveRight() {
        image.moveBy(1, 0);
    }

    public void moveDown() {
        image.moveBy(0, -1);
    }

    public void remove() {
        scene.remove(image);
    }

    public void moveBy(int x, int y) {
        image.moveBy(x, y);
    }
}
