package de.pirckheimer_gymnasium.tetris.debug;

import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.LEFT;
import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.CENTER;
import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.RIGHT;

import java.awt.Color;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.text.TextAlignment;
import de.pirckheimer_gymnasium.tetris.text.TextLine;
import rocks.friedrich.engine_omega.Scene;

public class TextLineDebugScene extends Scene
{
    private int LINE_WIDTH = 18;

    private String TEXT = "Hello, World.";

    private Color COLOR = Tetris.COLOR_SCHEME_GREEN.getDark();

    public TextLineDebugScene()
    {
        setBackgroundColor(Color.GRAY);
        createTextLine(3, LEFT);
        createTextLine(0, CENTER);
        createTextLine(-3, RIGHT);
    }

    private void createTextLine(int y, TextAlignment alignment)
    {
        TextLine line = new TextLine(this, -9, y, LINE_WIDTH);
        line.write(TEXT, COLOR, alignment);
    }

    public static void main(String[] args)
    {
        Tetris.setDebug(true);
        Tetris.start(new TextLineDebugScene());
    }
}
