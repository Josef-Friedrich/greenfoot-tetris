package rocks.friedrich.tetris;

import ea.Scene;
import ea.Game;

public class Tetris {

    public static void main(String[] args) {
        Scene scene = new FirstScreen();
        // 160x144 x4 -> 640x576
        Game.start(640, 576, scene);
    }

}
