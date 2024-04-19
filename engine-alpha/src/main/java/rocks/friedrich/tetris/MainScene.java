package rocks.friedrich.tetris;

import ea.Scene;
import ea.FrameUpdateListener;
import ea.Game;

import ea.actor.Text;
import java.util.Timer;
import java.util.TimerTask;

public class MainScene extends Scene implements FrameUpdateListener {

    public MainScene() {
        Text helloworld = new Text("Hello World", 2);
        helloworld.setCenter(0, 1);
        this.add(helloworld);
        Game.setDebug(true);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);
    }

    @Override
    public void onFrameUpdate(float deltaSeconds) {
        // System.out.println(deltaSeconds);
    }
}
