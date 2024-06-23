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

import java.awt.Color;

import de.pirckheimer_gymnasium.engine_pi.Scene;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.text.TextField;

/**
 * @author Josef Friedrich
 */
public class TextFieldDebugScene extends Scene
{
    public TextFieldDebugScene()
    {
        TextField textField = new TextField(this, 0, 8, 5, 20);
        getCamera().setPostion(10, 8);
        textField.write("Hello, World. Lorem ipsum. Lorem ipsum. Lorem ipsum",
                Tetris.COLOR_SCHEME_GREEN.getDark());
        setBackgroundColor(Color.GRAY);
    }

    public static void main(String[] args)
    {
        Tetris.start(new TextFieldDebugScene(), true);
    }
}
