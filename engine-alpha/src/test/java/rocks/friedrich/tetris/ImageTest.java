package rocks.friedrich.tetris;

import static rocks.friedrich.tetris.Image.changeColorSchema;
import static rocks.friedrich.tetris.Image.read;
import static rocks.friedrich.tetris.Image.scale;
import static rocks.friedrich.tetris.Image.write;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class ImageTest
{
    @Test
    public void testCover(@TempDir Path tempDir) throws IOException
    {
        Path file = tempDir.resolve("CopyrightScreen.png");
        write(scale(read("CopyrightScreen.png"), 4), file.toString());
    }

    @Test
    public void testChangeColors(@TempDir Path tempDir) throws IOException
    {
        Path file = tempDir.resolve("TitleScreen.png");
        write(changeColorSchema(read("TitleScreen.png")),
                file.toString());
    }
}
