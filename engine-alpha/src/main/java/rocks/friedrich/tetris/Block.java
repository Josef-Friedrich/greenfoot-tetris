package rocks.friedrich.tetris;

import ea.actor.Image;

/**
 * Represents a block of a tetromino
 */
public class Block extends Image {
    Block(String blockName) {
        super("images/blocks/block-" + blockName + ".png", 60);
    }

    public void moveLeft() {
        setPosition(getX() - 1, getY());
    }

    public void moveRight() {
        setPosition(getX() + 1, getY());
    }

    public void moveDown() {
        setPosition(getX(), getY() - 1);
    }
}
