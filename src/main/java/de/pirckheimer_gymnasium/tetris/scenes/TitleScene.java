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
package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.tetris.Tetris;

/**
 * @author Josef Friedrich
 */
public class TitleScene extends BaseScene
{
    public TitleScene()
    {
        super("title");
        delay(4, () -> {
            startIngameScene();
        });
    }

    public void startIngameScene()
    {
        Tetris.start(new IngameScene());
    }

    public static void main(String[] args)
    {
        Tetris.start(new TitleScene());
    }
}
