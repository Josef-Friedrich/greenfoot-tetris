package rocks.friedrich.tetris;

import ea.Scene;
import ea.Game;

import java.util.Timer;
import java.util.TimerTask;

public class MainScene extends Scene {

    public MainScene() {
        Block block = new Block("O");
        block.setPosition(0, 0);
        add(block);
        Game.setDebug(true);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                block.moveDown();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
