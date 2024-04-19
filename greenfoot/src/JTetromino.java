import greenfoot.*;

/**
 * represents a J tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class JTetromino extends Tetromino
{
    JTetromino()
    {
        super("J");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX(3 ) +1;
        getWorld().addObject(blocks[0], start, 0);
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
                blocks[0].setLocation(blocks[2].getX() - 1, blocks[2].getY() + 1);
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                break;
            case WEST:
                blocks[0].setLocation(blocks[2].getX() + 1, blocks[2].getY() + 1);
                blocks[1].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                break;
            case SOUTH:
                blocks[0].setLocation(blocks[2].getX() + 1, blocks[2].getY() - 1);
                blocks[1].setLocation(blocks[2].getX(), blocks[2].getY() - 1);
                blocks[3].setLocation(blocks[2].getX(), blocks[2].getY() + 1);
                break;
            case EAST:
                blocks[0].setLocation(blocks[2].getX() - 1, blocks[2].getY() - 1);
                blocks[1].setLocation(blocks[2].getX() - 1, blocks[2].getY());
                blocks[3].setLocation(blocks[2].getX() + 1, blocks[2].getY());
                break;
        }
    }

    protected boolean isTurnPossible()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        switch (direction)
        {
            case NORTH:
                return blocks[2].getX() < world.getWidth() - 1;
            case WEST:
                return true;
            case SOUTH:
                return blocks[2].getX() > 0;
            default: // case EAST:
                return blocks[2].getY() < world.getHeight() - 3;
        }
    }
}
