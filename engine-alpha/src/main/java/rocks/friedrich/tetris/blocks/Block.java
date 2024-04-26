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
        image.setPosition(image.getX() - 1, image.getY());
    }

    public void moveRight() {
        image.setPosition(image.getX() + 1, image.getY());
    }

    public void moveDown() {
        image.setPosition(image.getX(), image.getY() - 1);
    }

    public void remove() {
        scene.remove(image);
    }

    public void moveBy(int x, int y) {
        image.moveBy(x, y);
    }
}
