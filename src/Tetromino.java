import greenfoot.*;

/**
 * abstract super class of all tetrominos; contains the act-method
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public abstract class Tetromino extends Actor
{

    // possible directions of a tetromino
    protected static final int NORTH = 0;

    protected static final int WEST = 1;

    protected static final int SOUTH = 2;

    protected static final int EAST = 3;

    protected Block[] blocks; // each tetromino consists of four blocks

    int direction; // direction of the tetromino

    boolean dead; // is the tetromino dead?

    private int counter; // internal counter

    Tetromino(String blockName)
    {
        // Damit das Vorschaubild nicht angezeigt wird. Der Tetromino ist ein Behälter für 4 Blöcke. Der Tetromino selber hat kein Bild.
        setImage("blocks/block-blank.png");
        blocks = new Block[4];
        for (int i = 0; i < 4; i++)
        {
            blocks[i] = new Block(blockName);
        }
        counter = 0;
        dead = false;
        TetrisWorld.getWorld().addObject(this, 0, TetrisWorld.getWorld().getHeight() - 1);
    }

    // changes the direction of a tetromino; the current direction is stored in
    // attribute direction
    abstract protected void setDirection();

    // left most block of the tetromino (depending on its direction)
    abstract protected Block getMostLeft();

    // right most block of the tetromino (depending on its direction)
    abstract protected Block getMostRight();

    // is left turn possible?
    abstract protected boolean isTurnPossible();

    // deletes the four blocks of a tetromino
    void delete()
    {
        for (int i = 0; i < 4; i++)
        {
            getWorld().removeObject(blocks[i]);
        }
        dead = true;
    }

    // the current tetromino (more precisely its blocks) are falling down
    public void act()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        if (world.getCurrentTetromino() == null)
        { // game ended
            world.gameOver();
            return;
        }

        if (dead)
            return;

        // checking user interactions
        boolean keyAction = false;
        if (Greenfoot.isKeyDown("left") && counter < 4)
        {
            if (moveLeft())
            {
                counter++;
                keyAction = true;
            }
        }
        if (Greenfoot.isKeyDown("right") && counter < 4)
        {
            if (moveRight())
            {
                counter++;
                keyAction = true;
            }
        }
        if (Greenfoot.isKeyDown("up") && counter < 3)
        {
            if (turnLeft())
            {
                counter++;
                keyAction = true;
            }
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown(" "))
        {
            slideDownQuick();
            return;
        }

        if (keyAction)
        {
            return;
        }

        // one row down
        slideDown();
        counter = 0;
    }

    // one column to the left
    boolean moveLeft()
    {
        if (isLeftOccupied())
            return false;
        for (int i = 0; i < 4; i++)
        {
            blocks[i].setLocation(blocks[i].getX() - 1, blocks[i].getY());
        }
        SoundPlayer.playBlockMove();
        return true;
    }

    // left shift possible?
    boolean isLeftOccupied()
    {
        if (getMostLeft().getX() == 0)
        {
            return true;
        }
        TetrisWorld world = TetrisWorld.getWorld();
        blocks: for (int i = 0; i < 4; i++)
        {
            java.util.List<Block> list =
                            world.getObjectsAt(blocks[i].getX() - 1, blocks[i].getY(), Block.class);
            if (list.size() == 0)
            {
                continue;
            }
            // then list.size() == 1
            Actor a = (Actor) list.get(0);
            for (int j = 0; j < 4; j++)
            {
                if (i == j)
                    continue;
                if (a == blocks[j])
                    continue blocks;
            }
            return true;
        }
        return false;
    }

    // one column to the right
    boolean moveRight()
    {
        if (isRightOccupied())
            return false;
        for (int i = 0; i < 4; i++)
        {
            blocks[i].setLocation(blocks[i].getX() + 1, blocks[i].getY());
        }
        SoundPlayer.playBlockMove();
        return true;
    }

    // right shift possible?
    boolean isRightOccupied()
    {
        if (getMostRight().getX() == TetrisWorld.getWorld().getWidth() - 1)
        {
            return true;
        }
        TetrisWorld world = TetrisWorld.getWorld();
        blocks: for (int i = 0; i < 4; i++)
        {
            java.util.List<Block> list =
                            world.getObjectsAt(blocks[i].getX() + 1, blocks[i].getY(), Block.class);
            if (list.size() == 0)
            {
                continue;
            }
            // then list.size() == 1
            Actor a = (Actor) list.get(0);
            for (int j = 0; j < 4; j++)
            {
                if (i == j)
                    continue;
                if (a == blocks[j])
                    continue blocks;
            }
            return true;
        }
        return false;
    }

    // change the direction of the tetromino
    boolean turnLeft()
    {
        if (!isTurnPossible())
        {
            return false;
        }
        int oldDir = direction;
        direction = (direction + 1) % 4;
        setDirection();
        TetrisWorld world = TetrisWorld.getWorld();
        for (int i = 0; i < 4; i++)
        {
            java.util.List<Block> list = world.getObjectsAt(blocks[i].getX(), blocks[i].getY(), null);
            if (list.size() > 1)
            {
                direction = oldDir;
                setDirection();
                return false;
            }
        }
        SoundPlayer.playBlockRotate();
        return true;
    }

    // tetromino slides one row down
    boolean slideDown()
    {
        // checks whether the tetromino is on the bottom row
        for (int i = 0; i < 4; i++)
        {
            if (!isBelowFree(i))
            {
                checkRows();
                die();
                return false;
            }
        }

        // falling down
        for (int i = 0; i < 4; i++)
        {
            blocks[i].setLocation(blocks[i].getX(), blocks[i].getY() + 1);
        }
        return true;
    }

    // the tetromino is sliding to the bottom row
    void slideDownQuick()
    {
        while (slideDown());
    }

    /**
     * Überprüfe, ob die Zelle unterhalb des mit der Indexnummer addressierten Blocks frei ist.
     *
     * @param index Die Indexnummer des Blocks (0-3)
     *
     * @return Wahr, wenn die Zelle unterhalb des Blocks nicht belegt ist, anderfalls falsch.
     */
    boolean isBelowFree(int index)
    {
        TetrisWorld world = TetrisWorld.getWorld();
        java.util.List<Block> list = world.getObjectsAt(blocks[index].getX(), blocks[index].getY() + 1, null);
        if (list.size() == 0)
        {
            return true;
        }
        // then list.size() == 1
        Actor a = (Actor) list.get(0);
        for (int i = 0; i < 4; i++)
        {
            if (i == index)
                continue;
            if (a == blocks[i])
                return true;
        }
        return false;
    }

    // checks whether there exists completed rows which can be removed
    void checkRows()
    {
        int noOfRows = 0;
        TetrisWorld world = TetrisWorld.getWorld();
        rows: for (int row = world.getHeight() - 3; row >= 0; row--)
        {
            for (int c = 0; c < world.getWidth(); c++)
            {
                java.util.List<Block> blocks = world.getObjectsAt(c, row, Block.class);
                if (blocks.size() == 0)
                {
                    continue rows; // next row
                }
            }
            // clear row
            clearRow(row);
            noOfRows++;
            triggerLandslide(row);
            row++;
        }
        if (noOfRows > 0)
        {
            world.newPoints(noOfRows);
        }
    }

    // removes the blocks of a row
    void clearRow(int row)
    {
        TetrisWorld world = TetrisWorld.getWorld();
        for (int c = 0; c < world.getWidth(); c++)
        {
            world.removeObjects(world.getObjectsAt(c, row, Block.class));
        }
    }

    /**
     * Löse einen Erdrutsch (trigger landslide) aus, d. h. scheibe alle Reihen ab einer angegeben Y-Koordinate um eine Position nach unten.
     *
     * @param rowY Die Y-Koordinate der Reihe, von der aus die obenliegenden Reihen um eins nach unten gerutscht werden soll.
     */
    void triggerLandslide(int rowY)
    {
        TetrisWorld world = TetrisWorld.getWorld();
        for (int row = rowY - 1; row >= 0; row--)
        {
            for (int column = 0; column < world.getWidth(); column++)
            {
                Block block = getBlockAt(column, row);
                if (block != null)
                {
                    block.setLocation(block.getX(), block.getY() + 1);
                }
            }
        }
    }

    Block getBlockAt(int column, int row) {
        TetrisWorld world = TetrisWorld.getWorld();

        java.util.List<Block> blocks = world.getObjectsAt(column, row, Block.class);
        if (blocks.size() > 0)
        {
            return blocks.get(0);
        }
        return null;
    }

    // kills the tetromino
    void die()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        world.removeObject(this);
        dead = true;
        Tetromino tetro = world.genTetromino();
        if (checkEnd(tetro))
        {
            tetro.delete();
            world.setCurrentTetromino(null);
            world.gameOver();
        }
        else
        {
            TetrisWorld.getWorld().setCurrentTetromino(tetro);
        }
    }

    // checks whether the game has completed
    boolean checkEnd(Tetromino tetro)
    {
        TetrisWorld world = TetrisWorld.getWorld();
        for (int i = 0; i < 4; i++)
        {
            java.util.List<Block> list =
                            world.getObjectsAt(tetro.blocks[i].getX(), tetro.blocks[i].getY(), Block.class);
            if (list.size() > 1)
            {
                return true;
            }
        }
        return false;
    }

    // generates a direction randomly
    int genDirection()
    {
        return (int) (Math.random() * 4);
    }

    // return the number of digits of a number
    int length(int number)
    {
        if (number < 10)
            return 1;
        return length(number / 10) + 1;
    }
}
