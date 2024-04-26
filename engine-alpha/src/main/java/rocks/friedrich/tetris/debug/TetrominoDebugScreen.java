package rocks.friedrich.tetris.debug;

import ea.Game;
import ea.Scene;
import ea.event.KeyListener;
import rocks.friedrich.tetris.tetrominos.*;
import java.awt.event.KeyEvent;

public class TetrominoDebugScreen extends Scene implements KeyListener {

    private Tetromino t;
    private Tetromino i;

    public TetrominoDebugScreen() {
        t = createTetromino("T", -1, 0);
        i = createTetromino("I", 3, 0);
    }

    private Tetromino createTetromino(String name, int x, int y) {
        switch (name) {
            case "L":
                return new L(this, x, y);
            case "J":
                return new J(this, x, y);
            case "I":
                return new I(this, x, y);
            case "O":
                return new O(this, x, y);
            case "Z":
                return new Z(this, x, y);
            case "S":
                return new S(this, x, y);
            case "T":
                return new T(this, x, y);
            default:
                return new L(this, x, y);
        }
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                t.moveLeft();
                i.moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                t.moveRight();
                i.moveRight();

                break;

            case KeyEvent.VK_DOWN:
                t.moveDown();
                i.moveDown();

                break;

            case KeyEvent.VK_SPACE:
                t.rotate();
                i.rotate();
                break;
        }
    }

    public static void main(String[] args) {
        Scene scene = new TetrominoDebugScreen();
        // 160x144 x4 -> 640x576
        Game.setDebug(true);
        Game.start(640, 576, scene);
    }

}
