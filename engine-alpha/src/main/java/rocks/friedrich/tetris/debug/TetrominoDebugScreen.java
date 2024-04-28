package rocks.friedrich.tetris.debug;

import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;
import rocks.friedrich.tetris.tetrominos.*;
import java.awt.event.KeyEvent;

public class TetrominoDebugScreen extends Scene implements KeyListener {

    Tetromino[] t;

    public TetrominoDebugScreen() {
        t = new Tetromino[7];
        t[0] = createTetromino("L", -5, 5);
        t[1] = createTetromino("J", 0, 5);
        t[2] = createTetromino("I", 5, 5);
        t[3] = createTetromino("O", 0, 0);
        t[4] = createTetromino("Z", -5, -5);
        t[5] = createTetromino("S", 0, -5);
        t[6] = createTetromino("T", 5, -5);

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
                for (Tetromino i : t) {
                    i.moveLeft();
                }
                break;

            case KeyEvent.VK_RIGHT:
                for (Tetromino i : t) {
                    i.moveRight();
                }
                break;

            case KeyEvent.VK_DOWN:
                for (Tetromino i : t) {
                    i.moveDown();
                }
                break;

            case KeyEvent.VK_SPACE:
                for (Tetromino i : t) {
                    i.rotate();
                }
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
