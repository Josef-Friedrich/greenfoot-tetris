package rocks.friedrich.tetris.debug;

import ea.Game;
import ea.Scene;
import rocks.friedrich.tetris.screens.CopyrightScreen;

public class RotationDebugScreen extends Scene {

    public static void main(String[] args) {
        Scene scene = new CopyrightScreen();
        // 160x144 x4 -> 640x576
        Game.start(640, 576, scene);
    }

}
