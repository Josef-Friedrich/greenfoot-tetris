package rocks.friedrich.tetris;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.screens.CopyrightScreen;
import rocks.friedrich.engine_omega.Game;

public class Tetris {

    public static void main(String[] args) {
        Scene scene = new CopyrightScreen();
        // 160x144 x4 -> 640x576
        Game.start(640, 576, scene);
    }

}
