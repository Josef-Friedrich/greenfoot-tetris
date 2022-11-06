import greenfoot.*;

/**
 * represents a T tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class TTetromino extends Tetromino
{
    TTetromino()
    {
        super("T");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX(2);
        getWorld().addObject(blocks[0], start + 1, 0);
        getWorld().addObject(blocks[1], start, 1);
        getWorld().addObject(blocks[2], start + 1, 1);
        getWorld().addObject(blocks[3], start + 2, 1);
        setDirection();
    }

    protected void setDirection()
    {
        switch (direction)
        {
            case NORTH:
                blocks[0].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                blocks[1].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                break;
            case WEST:
                blocks[0].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                break;
            case SOUTH:
                blocks[0].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                blocks[1].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                break;
            case EAST:
                blocks[0].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                break;
        }
    }

    protected boolean isTurnPossible()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        switch (direction)
        {
            case NORTH:
                return blocks[2].getY() < world.getHeight() - 3;
            case WEST:
                return blocks[2].getX() < world.getWidth() - 1;
            case SOUTH:
                return true;
            default:
                return blocks[2].getX() >= 1;
        }
    }


}
