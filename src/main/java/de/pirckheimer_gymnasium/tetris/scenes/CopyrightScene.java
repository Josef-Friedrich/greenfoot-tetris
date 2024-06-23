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

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.engine_pi.event.KeyStrokeListener;
import de.pirckheimer_gymnasium.tetris.Tetris;

/**
 * Das ist der erste Bildschirm, der beim Starten des Spiels angezeigt wird.
 *
 * @author Josef Friedrich
 */
public class CopyrightScene extends BaseScene implements KeyStrokeListener
{
    public CopyrightScene()
    {
        super("copyright");
        delay(4, () -> startTitleScene());
    }

    public void startTitleScene()
    {
        Tetris.start(new TitleScene());
    }

    /**
     * Wenn eine beliebige Taste gedrückt wird, wird zum nächsten Bildschirm,
     * der Titelszene, gesprungen.
     */
    public void onKeyDown(KeyEvent keyEvent)
    {
        startTitleScene();
    }

    public static void main(String[] args)
    {
        Tetris.start(new CopyrightScene());
    }
}
