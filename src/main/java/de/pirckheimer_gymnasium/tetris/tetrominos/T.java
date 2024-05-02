package de.pirckheimer_gymnasium.tetris.tetrominos;

import rocks.friedrich.engine_omega.Scene;

public class T extends Tetromino
{
    public T(Scene scene, BlockGrid grid, int x, int y, boolean debug)
    {
        super(scene, grid, x, y, debug);
        addBlock(0, "T", x, y);
        addBlock(1, "T", x - 1, y);
        addBlock(2, "T", x + 1, y);
        addBlock(3, "T", x, y - 1);
    }

    protected void setRotation()
    {
        switch (rotation)
        {
        case 0:
            setBlockMotion(1, -1, 1);
            setBlockMotion(2, 1, -1);
            setBlockMotion(3, -1, -1);
            break;

        case 1:
            setBlockMotion(2, -1, 1);
            break;

        case 2:
            setBlockMotion(3, 1, 1);
            break;

        case 3:
            setBlockMotion(1, 1, -1);
            break;
        }
    }

    @Override
    protected Block[] getLeftwardsBlocks()
    {
        switch (rotation)
        {
        case 0:
            return getBlocks(1, 3);

        case 1:
            return getBlocks(2, 1, 3);

        case 2:
            return getBlocks(2, 1);

        case 3:
            return getBlocks(2, 0, 1);

        default:
            return new Block[0];
        }
    }

    @Override
    protected Block[] getRightwardsBlocks()
    {
        switch (rotation)
        {
        case 0:
            return getBlocks(2, 3);

        case 1:
            return getBlocks(2, 0, 3);

        case 2:
            return getBlocks(2, 3);

        case 3:
            return getBlocks(2, 3, 1);

        default:
            return new Block[0];
        }
    }

    @Override
    protected Block[] getDownwardsBlocks()
    {
        switch (rotation)
        {
        case 0:
            return getBlocks(1, 3, 2);

        case 1:
            return getBlocks(1, 3);

        case 2:
            return getBlocks(1, 0, 3);

        case 3:
            return getBlocks(1, 3);

        default:
            return new Block[0];
        }
    }
}
