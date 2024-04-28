import greenfoot.*;

/**
 * The world of tetris
 * <p>
 * Der Bildschirmausschnitt des Gameboys ist 160x144 Pixel. Ein Block hat die Größe 8x8.
 * Der Bildschirmausschnitt lässt sich als mit 20x18 Blöcken ausfüllen. Wir verwenden
 * Bilder, die um den Faktor 4 vergrößert wurden.
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (15.02.2007)
 */
public class TetrisWorld extends World
{
    private static final int BLOCK_SIZE = 32;

    private static final int COLS = 20;

    private static final int ROWS = 18;

    /**
     * Das Spielfeld hat links einen Abstand zum Bildschirmrand von 2 Blöcken.
     */
    public static final int PLAYGROUND_LEFT_X = 3;

    /**
     * Das Spielfeld hat rechts einen Abstand zum Bildschirmrand von 8 Blöcken.
     */
    public static final int PLAYGROUND_RIGHT_X = 10;
    public static final int PLAYGROUND_TOP_Y = 0;
    public static final int PLAYGROUND_BOTTOM_Y = 17;

    private static TetrisWorld world = null;

    private Points pointView;

    private Tetromino currentTetromino;

    public int numberOfTetrominos;

    private int speed;

    /**
     * Creates a tetris world with 10 columns and 22 rows
     */
    public TetrisWorld()
    {
        super(COLS, ROWS, BLOCK_SIZE);

        world = this;

        setBackground("fullscreen/background.png");

        this.pointView = new Points();

        this.speed = 30;
        Greenfoot.setSpeed(this.speed);
        this.numberOfTetrominos = 0;
        currentTetromino = genTetromino();
    }

    public static int getPlaygroundWidth() {
        // For example TetrisWorld.PLAYGROUND_LEFT_X = 3 and TetrisWorld.PLAYGROUND_RIGHT_X = 10
        // 1 2 | 3 4 5 6 7 8 9 10 | 11 12 13 14 15 16 17 18
        // 10 - 3 + 1 = 8
        return PLAYGROUND_RIGHT_X - PLAYGROUND_LEFT_X + 1;
    }
    public static int getPlaygroundHeight() {
        // 17 - 0 + 1 = 18
        return PLAYGROUND_BOTTOM_Y - PLAYGROUND_TOP_Y + 1;
    }
    // returns the current world
    static TetrisWorld getWorld()
    {
        return world;
    }

    // returns the current tetromino or null if game terminated
    Tetromino getCurrentTetromino()
    {
        return currentTetromino;
    }

    // changes the current tetromino
    void setCurrentTetromino(Tetromino t)
    {
        SoundPlayer.playBlockDrop();
        currentTetromino = t;
    }

    // creates randomly a new tetromino
    Tetromino genTetromino()
    {
        this.numberOfTetrominos += 1;

        int rand = (int) (Math.random() * 7);
        switch (rand)
        {
            case 0:
                return new ITetromino();
            case 1:
                return new JTetromino();
            case 2:
                return new LTetromino();
            case 3:
                return new OTetromino();
            case 4:
                return new TTetromino();
            case 5:
                return new STetromino();
            default:
                return new ZTetromino();
        }
    }

    // adds new points to the point view
    void newPoints(int rows)
    {
        int p = 0;
        switch (rows)
        {
            case 1:
                p = 40;
                break;
            case 2:
                p = 100;
                break;
            case 3:
                p = 300;
                break;
            case 4:
                p = 1200;
                break;
        }
        pointView.add(p);
    }

    // returns the current points of the player
    int getPoints()
    {
        return pointView.getPoints();
    }

    // game over
    void gameOver()
    {
        addObject(new ScoreBoard(getPoints()), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    public void started() {
        SoundPlayer.playKorobeiniki();
    }

}
