package de.pirckheimer_gymnasium.tetris;

import static de.pirckheimer_gymnasium.tetris.Image.changeColorSchema;
import static de.pirckheimer_gymnasium.tetris.Image.read;
import static de.pirckheimer_gymnasium.tetris.Image.scale;
import static de.pirckheimer_gymnasium.tetris.Image.write;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class ImageTest
{
    @Test
    public void testCover(@TempDir Path tempDir) throws IOException
    {
        Path file = tempDir.resolve("copyright.png");
        write(scale(read("fullscreen/copyright.png"), 4), file.toString());
    }

    @Test
    public void testChangeColors(@TempDir Path tempDir) throws IOException
    {
        Path file = tempDir.resolve("title.png");
        write(changeColorSchema(read("fullscreen/title.png")),
                file.toString());
    }
}
