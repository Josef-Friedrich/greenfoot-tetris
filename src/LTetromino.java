import greenfoot.*;

/**
 * represents a L tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class LTetromino extends Tetromino
{
    LTetromino()
    {
        super("L");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX(2);
        getWorld().addObject(blocks[0], start + 2, 0);
        getWorld().addObject(blocks[1], start + 2, 1);
        getWorld().addObject(blocks[2], start + 1, 1);
        getWorld().addObject(blocks[3], start, 1);
        setDirection();
    }

    protected void setDirection()
    {
        switch (direction)
        {
            case NORTH:
                blocks[0].setLocation(blocks[2].getX() + 1, blocks[2].getY() + 1);
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                break;
            case WEST:
                blocks[0].setLocation(blocks[2].getX() + 1, blocks[2].getY() - 1);
                blocks[1].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                break;
            case SOUTH:
                blocks[0].setLocation(blocks[2].getX() - 1, blocks[2].getY() - 1);
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                break;
            case EAST:
                blocks[0].setLocation(blocks[2].getX() - 1, blocks[2].getY() + 1);
                blocks[1].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                break;
        }
    }

    protected Block getLeftmost()
    {
        switch (direction)
        {
            case NORTH:
                return blocks[2];
            case WEST:
                return blocks[3];
            default:
                return blocks[0];
        }
    }

    protected Block getRightmost()
    {
        switch (direction)
        {
            case NORTH:
            case WEST:
                return blocks[0];
            case SOUTH:
                return blocks[1];
            default: // case EAST:
                return blocks[3];
        }
    }

    protected boolean isTurnPossible()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        switch (direction)
        {
            case NORTH:
                return blocks[2].getX() >= 1;
            case WEST:
                return blocks[2].getY() < world.getHeight() - 3;
            case SOUTH:
                return blocks[2].getX() < world.getWidth() - 1;
            default: // case EAST:
                return true;
        }
    }


}
