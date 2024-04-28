package rocks.friedrich.tetris.scenes;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.tetris.blocks.Block;
import rocks.friedrich.engine_omega.Game;

import java.util.Timer;
import java.util.TimerTask;

public class IngameScene extends Scene
{
    public IngameScene()
    {
        Block block = new Block(this, "O", 0, 0);
        Game.setDebug(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                block.moveDown();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
