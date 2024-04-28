package rocks.friedrich.tetris.utils;

import static rocks.friedrich.tetris.utils.ImagePreparer.changeColorSchema;
import static rocks.friedrich.tetris.utils.ImagePreparer.read;
import static rocks.friedrich.tetris.utils.ImagePreparer.scale;
import static rocks.friedrich.tetris.utils.ImagePreparer.write;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ImagePreparerTest
{
    @Test
    public void testCover() throws IOException
    {
        write(scale(read("CopyrightScreen.png"), 4),
                "CopyrightScreen_pixelperfect-upscaling.png");
    }

    @Test
    public void testChangeColors() throws IOException
    {
        write(changeColorSchema(read("TitleScreen.png")),
                "CopyrightScreen_change_colors.png");
    }
}
