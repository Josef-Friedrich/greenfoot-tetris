import greenfoot.*;

/**
 * represents a Z tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class ZTetromino extends Tetromino
{
    ZTetromino()
    {
        super("Z");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX(2);
        getWorld().addObject(blocks[0], start, 1);
        getWorld().addObject(blocks[1], start + 1, 1);
        getWorld().addObject(blocks[2], start + 1, 2);
        getWorld().addObject(blocks[3], start + 2, 2);
        setDirection();
    }

    protected void setDirection()
    {
        switch (direction)
        {
            case NORTH:
            case SOUTH:
                blocks[0].setLocation(blocks[1].getX() - 1, blocks[1].getY());
                blocks[2].setLocation(blocks[1].getX(), blocks[1].getY() + 1);
                blocks[3].setLocation(blocks[1].getX() + 1, blocks[1].getY() + 1);
                break;
            case WEST:
            case EAST:
                blocks[0].setLocation(blocks[1].getX(), blocks[1].getY() - 1);
                blocks[2].setLocation(blocks[1].getX() - 1, blocks[1].getY());
                blocks[3].setLocation(blocks[1].getX() - 1, blocks[1].getY() + 1);
                break;
        }
    }

    protected boolean isTurnPossible()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        switch (direction)
        {
            case NORTH:
            case SOUTH:
                return blocks[2].getY() < world.getHeight() - 3;
            default: // WEST, EAST
                return blocks[1].getX() < world.getWidth() - 1;
        }
    }
}
