package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.Random;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.BlockGrid;
import de.pirckheimer_gymnasium.tetris.tetrominos.Tetromino;
import rocks.friedrich.engine_omega.FrameUpdateListener;
import rocks.friedrich.engine_omega.event.KeyListener;

public class IngameScene extends BaseScene
        implements KeyListener, FrameUpdateListener
{
    private BlockGrid grid;

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
     * According <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     */
    private int[] framesPerRow = new int[] { 53, 49, 45, 41, 37, 33, 28, 22, 17,
            11, 10, 9, 8, 7, 6, 6, 5, 5, 4, 4, 3 };

    /**
     * According <a href=
     * "https://harddrop.com/wiki/Tetris_%28Game_Boy%29">harddrop.com</a>
     */
    private double gameboyFrameRate = 59.73;

    private long latestDownMovement = 0;

    private boolean automaticDownMovement = true;

    private long downInterval = 0;

    public IngameScene()
    {
        super("ingame");
        // Das I-Tetromino ragt einen Block über das sichtbare Spielfeld hinaus,
        // wenn es in der Startposition gedreht wird, deshalb machen wir das
        // Blockgitter um eine Zeile höher.
        grid = new BlockGrid(Tetris.GRID_WIDTH, Tetris.HEIGHT + 1);
        createNextTetromino();
    }

    private void createNextTetromino()
    {
        // Beim ersten Mal müssen zwei zufällige Tetrominos erzeugt werden.
        // Wir müssen also zweimal eine Zufallszahl generieren.
        if (previewTetromino == null)
        {
            nextTetromino = random.nextInt(7);
        }
        tetromino = Tetromino.create(this, grid, nextTetromino, 4, 16,
                Tetris.DEBUG);
        nextTetromino = random.nextInt(7);
        // Entfernen des alten Vorschaubildes, falls vorhanden.
        if (previewTetromino != null)
        {
            previewTetromino.remove();
        }
        // Das Vorschaubild liegth außerhalb des Blockgitters. Wir übergeben der
        // Methode null.
        previewTetromino = Tetromino.create(this, null, nextTetromino, 14, 3,
                Tetris.DEBUG);
        downInterval = caculateDownInterval();
    }

    private long caculateDownInterval()
    {
        return (long) (1_000_000_000 / gameboyFrameRate * framesPerRow[level]);
    }

    private void moveDown()
    {
        if (!tetromino.moveDown())
        {
            createNextTetromino();
        }
        latestDownMovement = System.nanoTime();
    }

    @Override
    public void onFrameUpdate(float deltaSeconds)
    {
        if (!automaticDownMovement)
        {
            return;
        }
        if (System.nanoTime() - latestDownMovement > downInterval)
        {
            moveDown();
        }
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_LEFT:
            tetromino.moveLeft();
            break;

        case KeyEvent.VK_RIGHT:
            tetromino.moveRight();
            break;

        case KeyEvent.VK_DOWN:
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
