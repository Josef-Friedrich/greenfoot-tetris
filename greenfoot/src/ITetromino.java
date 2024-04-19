import greenfoot.*;

/**
 * represents a I tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class ITetromino extends Tetromino
{
    ITetromino()
    {
        super("I_mid");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX(3);
        for (int i = 0; i < 4; i++)
        {
            getWorld().addObject(blocks[i], start + i, 2);
        }
        setDirection();
    }

    protected void setDirection()
    {
        switch (direction)
        {
            case NORTH:
            case SOUTH:
                for (int i = 0; i < 4; i++)
                {
                    if (i == 1)
                        continue;
                    blocks[i].setLocation(blocks[1].getX(), blocks[1].getY() + 1 - i);
                }
                break;

            case WEST:
            case EAST:
                for (int i = 0; i < 4; i++)
                {
                    if (i == 1)
                        continue;
                    blocks[i].setLocation(blocks[1].getX() - 1 + i, blocks[1].getY());
                }
                break;
        }
    }

    protected boolean isTurnPossible()
    {
        switch (direction)
        {
            case NORTH:
            case SOUTH:
                return blocks[0].getX() >= 1 && blocks[3].getX() <= TetrisWorld.getWorld().getWidth() - 3;
            default: // EAST, WEST
                return blocks[0].getY() < TetrisWorld.getWorld().getHeight() - 3;
        }
    }


}
