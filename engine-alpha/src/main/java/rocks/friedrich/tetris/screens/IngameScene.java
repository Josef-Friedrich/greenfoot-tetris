package rocks.friedrich.tetris.screens;

import ea.Scene;
import rocks.friedrich.tetris.blocks.Block;
import ea.Game;

import java.util.Timer;
import java.util.TimerTask;

public class IngameScene extends Scene {

    public IngameScene() {
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
