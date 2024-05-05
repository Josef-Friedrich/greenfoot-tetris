package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Vector;

public class BlockMotion
{
    private int x;

    private int y;

    public BlockMotion(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public BlockMotion(Vector motion)
    {
        this((int) motion.getX(), (int) motion.getY());
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
}
