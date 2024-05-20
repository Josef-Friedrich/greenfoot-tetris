package de.pirckheimer_gymnasium.tetris.text;

import de.pirckheimer_gymnasium.tetris.Tetris;
import rocks.friedrich.engine_omega.Scene;

public class NumberDisplay extends TextLine
{
    public NumberDisplay(Scene scene, int x, int y, int maxDigits)
    {
        super(scene, x, y, maxDigits);
    }

    public void write(int number)
    {
        super.write(String.valueOf(number),
                Tetris.COLOR_SCHEME_GREEN.getBlack(), TextAlignment.RIGHT);
    }
}
