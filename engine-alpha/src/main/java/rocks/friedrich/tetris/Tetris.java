package rocks.friedrich.tetris;

import ea.Scene;
import ea.Game;

public class Tetris {

    public static void main(String[] args) {
        Scene scene = new MainScene();
        Game.start(400, 300, scene);
    }

}
