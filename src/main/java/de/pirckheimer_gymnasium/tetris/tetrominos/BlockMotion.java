package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Vector;

public class BlockMotion
{
    private int x;

    private int y;

    private boolean switchImage;

    public BlockMotion(int x, int y, boolean switchImage)
    {
        this.x = x;
        this.y = y;
        this.switchImage = switchImage;
    }

    public BlockMotion(Vector motion, boolean switchImage)
    {
        this((int) motion.getX(), (int) motion.getY(), switchImage);
    }

    public int getX()
    {
        return x;
    }

    public Vector getVector()
    {
        return new Vector(x, y);
    }

    public int getY()
    {
        return y;
    }

    public boolean getSwitchImage()
    {
        return switchImage;
    }
}
