/*
 * Copyright (c) 2024 Josef Friedrich and contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.pirckheimer_gymnasium.tetris.debug;

import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.CENTER;
import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.LEFT;
import static de.pirckheimer_gymnasium.tetris.text.TextAlignment.RIGHT;

import java.awt.Color;

import de.pirckheimer_gymnasium.engine_pi.Scene;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.text.TextAlignment;
import de.pirckheimer_gymnasium.tetris.text.TextLine;

/**
 * @author Josef Friedrich
 */
public class TextLineDebugScene extends Scene
{
    private final Color COLOR = Tetris.COLOR_SCHEME_GREEN.getDark();

    public TextLineDebugScene()
    {
        setBackgroundColor(Color.GRAY);
        createTextLine(3, LEFT);
        createTextLine(0, CENTER);
        createTextLine(-3, RIGHT);
    }

    private void createTextLine(int y, TextAlignment alignment)
    {
        int LINE_WIDTH = 18;
        TextLine line = new TextLine(this, -9, y, LINE_WIDTH);
        String TEXT = "Hello, World.";
        line.write(TEXT, COLOR, alignment);
    }

    public static void main(String[] args)
    {
        Tetris.setDebug(true);
        Tetris.start(new TextLineDebugScene());
    }
}
