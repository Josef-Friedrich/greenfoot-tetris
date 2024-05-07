package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.Random;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.Grid;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.FrameUpdateListener;
import rocks.friedrich.engine_omega.event.KeyListener;
import rocks.friedrich.engine_omega.Scene;

public class IngameScene extends BaseScene
        implements KeyListener, FrameUpdateListener
{
    private Grid grid;

    /**
     * Der Zufallsgenerator wird benötigt, um zufällig neue Tetrominos zu
     * erzeugen. Wir verwenden die Method nextInt() um zufällig Zahlen von 0 bis
     * einschließlich 6 zu bekommen.
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

    private int level = 0;

    /**
     * Nach wie vielen Frames ein Tetromino eine Reihe weiter nach unten gesetzt
     * wird und zwar im Verhältnis zur Bildwiederholungsrate des originalen
     * Gameboys {@code 59.73}.
     *
     * Quelle: <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     */
    private final int[] GB_FRAMES_PER_ROM = new int[] { 53, 49, 45, 41, 37, 33,
            28, 22, 17, 11, 10, 9, 8, 7, 6, 6, 5, 5, 4, 4, 3 };

    /**
     * Die Bildwiederholungsrate des originalen Gameboys pro Sekunde mal 100
     * (damit wir ganzzahlig ohne Rest teilen können): pro Sekunden
     * {@code 59.73}, mal hundert {@code 5973}.
     *
     * Quelle: <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     */
    private final int GB_FRAME_RATE = 5973;

    /**
     * Der Zeitstempel in Nanosekunden ({@code 1} Sekunden sind
     * {@code 1.000.000} Nanosekunden)
     */
    private long latestDown = 0;

    private boolean automaticDown = true;

    /**
     * Das Zeitintervall, wie lange es dauern soll, bis das Tetromino eine Reihe
     * weiter nach unten bewegt werden soll.
     */
    private long downInterval = 0;

    protected PressedKeyRepeater<Scene> keyRepeater;

    public IngameScene()
    {
        super("ingame");
        // Das I-Tetromino ragt einen Block über das sichtbare Spielfeld hinaus,
        // wenn es in der Startposition gedreht wird, deshalb machen wir das
        // Blockgitter um eine Zeile höher.
        grid = new Grid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        createNextTetromino();
        keyRepeater = new PressedKeyRepeater<Scene>(this);
        keyRepeater.addTask(KeyEvent.VK_RIGHT, () -> tetromino.moveRight());
        keyRepeater.addTask(KeyEvent.VK_LEFT, () -> tetromino.moveLeft());
        keyRepeater.addTask(KeyEvent.VK_DOWN, () -> tetromino.moveDown());
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
        downInterval = caculateDownInterval();
    }

    /**
     * Berechnet das Zeitintervall in Nanosekunden, wie lange es dauert, bis
     * sich das aktuelle Tetromino von einer Reihe zur darunterliegenden Reihe
     * bewegt.
     *
     * @return
     */
    private long caculateDownInterval()
    {
        // 1_000_000_000 / (5973 / 100)
        // (1_000_000_000 * 100) / 5973
        // 100_000_000_000 / 5973
        return 100_000_000_000L / GB_FRAME_RATE * GB_FRAMES_PER_ROM[level];
    }

    private void moveDown()
    {
        if (!tetromino.moveDown())
        {
            createNextTetromino();
        }
        latestDown = System.nanoTime();
    }

    @Override
    public void onFrameUpdate(float deltaSeconds)
    {
        if (!automaticDown)
        {
            return;
        }
        if (System.nanoTime() - latestDown > downInterval)
        {
            moveDown();
        }
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_S:
            downInterval = 0;
            break;

        case KeyEvent.VK_SPACE:
            tetromino.rotate();
            break;
        }
        if (Tetris.DEBUG)
        {
            grid.print();
        }
    }

    public static void main(String[] args)
    {
        Tetris.start(new IngameScene());
    }
}
