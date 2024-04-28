package rocks.friedrich.tetris.scenes;

public class BaseScene
{
    public static final int BLOCK_SIZE = 32;

    public static final int COLS = 20;

    public static final int ROWS = 18;

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
}
