package rocks.friedrich.tetris.blocks;

import ea.actor.Image;

public class Block extends Image {
    public Block(String blockName) {
        super("images/blocks/block-" + blockName + ".png", 32);
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
