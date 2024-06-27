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
import java.util.Random;

import de.pirckheimer_gymnasium.engine_pi.Game;
import de.pirckheimer_gymnasium.engine_pi.Resources;
import de.pirckheimer_gymnasium.engine_pi.actor.Rectangle;
import de.pirckheimer_gymnasium.engine_pi.event.KeyStrokeListener;
import de.pirckheimer_gymnasium.engine_pi.event.PeriodicTaskExecutor;
import de.pirckheimer_gymnasium.engine_pi.event.PressedKeyRepeater;
import de.pirckheimer_gymnasium.engine_pi.sound.SinglePlayTrack;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.FilledRowRange;
import de.pirckheimer_gymnasium.tetris.tetrominos.Grid;
import de.pirckheimer_gymnasium.tetris.tetrominos.SoftDrop;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import de.pirckheimer_gymnasium.tetris.text.NumberDisplay;

/**
 * @author Josef Friedrich
 */
class Sound
{
    private static void playMusic(String filename)
    {
        try
        {
            Game.getJukebox().playMusic(new SinglePlayTrack(
                    Resources.SOUNDS.get("sounds/" + filename)), true);
        }
        catch (Exception e)
        {
            // e.printStackTrace();
        }
    }

    public static void blockMove()
    {
        playMusic("Block_move.mp3");
    }

    public static void blockRotate()
    {
        playMusic("Block_rotate.mp3");
    }

    public static void blockDrop()
    {
        playMusic("Block_drop.mp3");
    }
}

/**
 * Die Hauptspiel-Szene.
 *
 * @author Josef Friedrich
 */
public class IngameScene extends BaseScene implements KeyStrokeListener
{
    private Grid grid;

    /**
     * Der Zufallsgenerator wird benötigt, um zufällig neue Tetrominos zu
     * erzeugen. Wir verwenden die Method {@code Random#nextInt()} um zufällig
     * Zahlen von {@code 0} bis einschließlich {@code 6} zu bekommen.
     *
     * @see #createNextTetromino()
     */
    private static Random random = new Random();

    /**
     * Die Nummer des nächsten Tetrominos.
     */
    private int nextTetromino;

    /**
     * Das aktuelle Tetromino, das gesteuert werden kann und automatisch nach
     * unten fällt.
     */
    private Tetromino tetromino;

    /**
     * Das Vorschaubild des nächsten Tetrominos im linken unteren Bereich.
     */
    private Tetromino previewTetromino;

    /**
     * Die Gesamtpunktezahl. Diese Nummernanzeige ist mit SCORE beschriftet und
     * ist oben rechts platziert.
     */
    private NumberDisplay score;

    /**
     * In welchem Level wir uns gerade befinden. Das erste Level ist 0. Diese
     * Nummernanzeige ist mit LEVEL beschriftet und ist rechts in der Mitte
     * platziert.
     */
    private NumberDisplay level;

    /**
     * Wie viele Zeilen bisher getilgt wurden. Diese Nummernanzeige ist mit
     * LINES beschriftet und ist unter der Level-Anzeige platziert.
     */
    private NumberDisplay clearedLines;

    /**
     * Ein Feld, das die Anzahl an Einzelbilder enthält, nach denen eine
     * Tetromino eine Zeile weiter nach unten rutscht.
     *
     * <p>
     * Die Zahl an der Index-Position {@code 0} gibt die Anzahl an Einzelbilder
     * des {@code 0}-ten Levels an, die {@code 1} die Anzahl des {@code 1}-ten
     * Level, etc.
     * </p>
     *
     * <p>
     * Nach wie vielen Einzelbildern ein Tetromino eine Zeile weiter nach unten
     * gesetzt wird und zwar im Verhältnis zum aktuellen Level.
     * </p>
     *
     * <p>
     * Quelle: <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     * </p>
     */
    private final int[] GB_FRAMES_PER_ROW = { 53, 49, 45, 41, 37, 33, 28, 22,
            17, 11, 10, 9, 8, 7, 6, 6, 5, 5, 4, 4, 3 };

    /**
     * Die Bildwiederholungsrate des originalen Gameboys pro Sekunde.
     *
     * <p>
     * Quelle: <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     * </p>
     */
    private final double GB_FRAME_RATE = 59.73;

    protected PressedKeyRepeater keyRepeater;

    PeriodicTaskExecutor periodicTask;

    /**
     * Dadurch kann die Bewegung der Tetrominos gesperrt werden, wenn sich das
     * Spiel gerade in einer Animation (z. B. Tilgung von Zeilen) befindet.
     */
    private boolean isInAnimation = false;

    /**
     * Gibt an, ob sich das Tetromino in einer Soft-Drop-Bewegung befindet. Als
     * Soft-Drop bezeichnet man die schnellere nach unten gerichtete Bewegung
     * des Tetromino.
     */
    private SoftDrop softDrop = null;

    public IngameScene()
    {
        super("ingame");
        // Das I-Tetromino ragt einen Block über das sichtbare Spielfeld hinaus,
        // wenn es in der Startposition gedreht wird, deshalb machen wir das
        // Blockgitter um eine Zeile höher.
        grid = new Grid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        createNextTetromino();
        score = new NumberDisplay(this, 13, 14, 4);
        level = new NumberDisplay(this, 12, 10, 4);
        clearedLines = new NumberDisplay(this, 12, 7, 4);
        periodicTask = repeat(caculateDownInterval(), (counter) -> {
            if (softDrop == null)
            {
                moveDown();
            }
        });
        keyRepeater = new PressedKeyRepeater();
        keyRepeater.addListener(KeyEvent.VK_DOWN, () -> {
            softDrop = new SoftDrop(tetromino);
        }, () -> {
            moveDown();
        }, () -> {
            softDrop = null;
        });
        keyRepeater.addListener(KeyEvent.VK_RIGHT, this::moveRight);
        keyRepeater.addListener(KeyEvent.VK_LEFT, this::moveLeft);
    }

    private void createNextTetromino()
    {
        // Beim ersten Mal müssen zwei zufällige Tetrominos erzeugt werden.
        // Wir müssen also zweimal eine Zufallszahl generieren.
        if (previewTetromino == null)
        {
            nextTetromino = random.nextInt(7);
        }
        tetromino = Tetromino.create(this, grid, nextTetromino, 4, 16);
        nextTetromino = random.nextInt(7);
        // Entfernen des alten Vorschaubildes, falls vorhanden.
        if (previewTetromino != null)
        {
            previewTetromino.remove();
        }
        // Das Vorschaubild liegt außerhalb des Blockgitters. Wir übergeben der
        // Methode null.
        previewTetromino = Tetromino.create(this, null, nextTetromino, 14, 3);
    }

    /**
     * https://tetris.wiki/Scoring
     *
     * @param clearedLines Die Anzahl an getilgten Zeilen.
     *
     * @return Eine Punkteanzahl zu der Gesamtpunktezahl hinzugezählt werden
     *         muss.
     */
    private int caculateScore(int clearedLines)
    {
        int score = 40;
        if (clearedLines == 2)
        {
            score = 100;
        }
        else if (clearedLines == 3)
        {
            score = 300;
        }
        else if (clearedLines == 4)
        {
            score = 1200;
        }
        int result = score * (level.get() + 1);
        assert result > 0;
        return result;
    }

    /**
     * Berechnet das Zeitintervall in Sekunden, wie lange es dauert, bis sich
     * das aktuelle Tetromino von einer Zeile zur darunterliegenden bewegt.
     *
     * <p>
     * Wir bereichnen das Intervall mit Hilfe des Dreisatzes, hier mit konkreten
     * Werte für das 0-te Level:
     * </p>
     *
     * {@code interval / 53 = 1 / 59.73} gibt {@code interval = 1 / 59.73 * 53}
     *
     * <p>
     * Mit Variablen
     * </p>
     *
     * {@code interval / GB_FRAMES_PER_ROW[level] = 1 / GB_FRAME_RATE} gibt
     * {@code interval = 1 / GB_FRAME_RATE * GB_FRAMES_PER_ROW[level] }
     */
    private double caculateDownInterval()
    {
        return 1.0 / GB_FRAME_RATE * GB_FRAMES_PER_ROW[level.get()];
    }

    /**
     * Bewegt das aktuelle Tetromino nach <b>links</b>.
     */
    private void moveLeft()
    {
        if (isInAnimation)
        {
            return;
        }
        if (tetromino.moveLeft())
        {
            Sound.blockMove();
        }
    }

    /**
     * Bewegt das aktuelle Tetromino nach <b>rechts</b>.
     */
    private void moveRight()
    {
        if (isInAnimation)
        {
            return;
        }
        if (tetromino.moveRight())
        {
            Sound.blockMove();
        }
    }

    /**
     * Bewegt das aktuelle Tetromino um eine Zeile nach unten.
     */
    private void moveDown()
    {
        if (isInAnimation)
        {
            return;
        }
        // Wenn sich das Tetromino nicht mehr weiter nach unten bewegen kann.
        if (!tetromino.moveDown())
        {
            // Wir stoppen alle Tastenwiederholer (z. B. ausgelöst durch einen
            // Softdrop), wenn sich ein Tetromino nicht
            // mehr weiter nach unten bewegen kann. Würden wir den Wiederholer
            // nicht stoppen, dann hätte das neue Tetromino gleich nach dem
            // Erscheinen ein erhöhtes Falltempo.
            keyRepeater.stop();
            Sound.blockDrop();
            if (softDrop != null)
            {
                score.add(softDrop.getDistance());
            }
            softDrop = null;
            var range = grid.getFilledRowRange();
            if (range != null)
            {
                clearLines(range);
            }
            else
            {
                // In der Methode clearLines() wird dann am Ende der Animation
                // createNextTetromino() aufgerufen.
                // Wenn keine Zeilen zu tilgen sind, wird keine Animation
                // stattfinden und wir können gleich das nächste Tetromino
                // erzeugen.
                createNextTetromino();
            }
        }
    }

    /**
     * Tilgt gefüllte Zeilen und führt eine Animation aus.
     *
     * <p>
     * Diese Methode wird ausgeführt, wenn es ausgefüllte Zeilen gibt, die
     * getilgt werden müssen.
     * </p>
     */
    private void clearLines(FilledRowRange range)
    {
        isInAnimation = true;
        Rectangle overlay = addRectangle(10, range.getRowCount(), 0,
                range.getFrom());
        overlay.setColor(Tetris.COLOR_SCHEME_GREEN.getLight());
        overlay.setVisible(false);
        periodicTask.pause();
        repeat(0.167, 8, (counter) -> {
            // 1. grau
            // 2. Zeile sichtbar
            // 3. grau
            // 4. Zeile sichtbar
            // 5. grau
            // 6. Zeile sichtbar
            // 7. Zeile getilgt
            // 8. Zeilen oberhalb nach unten gerutscht
            switch (counter)
            {
            case 1:
            case 3:
            case 5:
                overlay.setVisible(true);
                break;

            case 2:
            case 4:
            case 6:
                overlay.setVisible(false);
                break;

            case 7:
                grid.removeFilledRowRange(range);
                break;

            case 8:
                grid.triggerLandslide(range);
                remove(overlay);
                createNextTetromino();
                periodicTask.resume();
                clearedLines.add(range.getRowCount());
                score.add(caculateScore(range.getRowCount()));
                isInAnimation = false;
                break;
            }
        });
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_SPACE:
            boolean success = tetromino.rotate();
            if (success)
            {
                Sound.blockRotate();
            }
            break;
        }
        if (Game.isDebug())
        {
            grid.print();
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new IngameScene());
    }
}
