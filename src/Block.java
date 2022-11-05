import greenfoot.*;

/**
 * Represents a block of a tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class Block extends Actor
{
    Block(String blockName)
    {
        setImage("blocks/block-" + blockName + ".png");
    }
}
