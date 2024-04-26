package rocks.friedrich.tetris.blocks;

import ea.Scene;
import ea.actor.Image;

public class Block {

    private Image image;

    private Scene scene;

    public Block(Scene scene, String blockName, int x, int y) {
        this.scene = scene;
        image = new Image("images/blocks/block-" + blockName + ".png", 32);
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
}
