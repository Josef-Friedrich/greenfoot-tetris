package de.pirckheimer_gymnasium.tetris.tetrominos;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Scene;

public class Block
{
    private Image image;

    private Scene scene;

    private BlockGrid grid;

    public Block(Scene scene, BlockGrid grid, String blockName, int x, int y)
    {
        this.scene = scene;
        this.grid = grid;
        image = new Image("blocks/" + blockName + ".png");
        image.setPosition(x, y);
        scene.add(image);
    }

    public int getX()
    {
        return (int) image.getX();
    }

    public int getY()
    {
        return (int) image.getY();
    }

    public void moveLeft()
    {
        image.moveBy(-1, 0);
    }

    public void moveRight()
    {
        image.moveBy(1, 0);
    }

    public void moveDown()
    {
        image.moveBy(0, -1);
    }

    public void remove()
    {
        scene.remove(image);
    }

    public void moveBy(int x, int y)
    {
        image.moveBy(x, y);
    }

    public void rotateCounterClockwise()
    {
        image.rotateBy(90);
    }

    public void rotateClockwise()
    {
        image.rotateBy(-90);
    }
}
