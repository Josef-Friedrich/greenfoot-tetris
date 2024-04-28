package rocks.friedrich.tetris;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.screens.CopyrightScreen;
import rocks.friedrich.engine_omega.Game;

public class Tetris {

    public static final int BLOCK_SIZE = 8;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 18;
    public static final int SCALE = 4;
    public static boolean DEBUG = false;

    public static void start(Scene scene, boolean debug) {
        scene.getCamera().setZoom(Tetris.SCALE * Tetris.BLOCK_SIZE);
        Game.setDebug(debug);
        Game.start(BLOCK_SIZE * WIDTH * SCALE, BLOCK_SIZE * HEIGHT * SCALE, scene);
    }

    public static void start(Scene scene) {
        start(scene, false);
    }

    public static void main(String[] args) {
        Scene scene = new CopyrightScreen();
        Game.start(BLOCK_SIZE * WIDTH * SCALE, BLOCK_SIZE * HEIGHT * SCALE, scene);
    }
}
