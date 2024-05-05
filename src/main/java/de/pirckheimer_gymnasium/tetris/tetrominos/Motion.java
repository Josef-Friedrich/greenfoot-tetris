package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Vector;

class Motion
{
    private int x;

    private int y;

    public Motion(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Motion(Vector motion)
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
}
