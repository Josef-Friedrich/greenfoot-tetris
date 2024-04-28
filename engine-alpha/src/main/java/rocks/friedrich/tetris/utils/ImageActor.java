package rocks.friedrich.tetris.utils;

import rocks.friedrich.engine_omega.actor.Image;
import rocks.friedrich.tetris.Tetris;

public class ImageActor extends Image
{
    public ImageActor(String pathname)
    {
        super(ImagePreparer.get(pathname), Tetris.SCALE * Tetris.BLOCK_SIZE);
    }
}
