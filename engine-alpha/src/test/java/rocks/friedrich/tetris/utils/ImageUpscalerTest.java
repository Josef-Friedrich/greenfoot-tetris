package rocks.friedrich.tetris.utils;

import java.awt.Color;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ImageUpscalerTest {

    @Test
    public void testCover() throws IOException {

        ImageUpscaler.write(ImageUpscaler.scale(ImageUpscaler.read("CopyrightScreen.png"), 4),
                "CopyrightScreen_pixelperfect-upscaling.png");


    }

    @Test
    public void testChangeColors() throws IOException {

        ImageUpscaler.write(
                ImageUpscaler.changeColors(ImageUpscaler.read("CopyrightScreen.png"), Color.BLACK, Color.RED),
                "CopyrightScreen_change_colors.png");

    }
}
