package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import rocks.friedrich.engine_omega.FrameUpdateListener;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

class TurboFireExecutor implements FrameUpdateListener, KeyListener
{
    private Scene scene;

    private float countdown;

    private TurboFireTask fire;

    public TurboFireExecutor(Scene scene, TurboFireTask fire)
    {
        this.scene = scene;
        this.fire = fire;
        countdown = fire.getInterval();
        this.scene.addKeyListener(this);
        this.scene.addFrameUpdateListener(this);
    }

    @Override
    public void onFrameUpdate(float deltaSeconds)
    {
        countdown -= deltaSeconds;
        if (countdown < 0)
        {
            fire.run();
            countdown = fire.getInterval();
        }
    }

    public void onKeyDown(KeyEvent e)
    {
        // Do nothing
    }

    @Override
    public void onKeyUp(KeyEvent e)
    {
        if (e.getKeyCode() == fire.getKeyCode())
        {
            scene.removeKeyListener(this);
            scene.removeFrameUpdateListener(this);
        }
    }
}

/**
 * Datencontainer
 *
 * Bei gedrückter Taste mehrmals die gleiche Aktionen in einem bestimmten
 * Abstand ausführen.
 */
class TurboFireTask
{
    private float interval;

    private int keyCode;

    private Runnable runnable;

    public TurboFireTask(int keyCode, float interval, Runnable runnable)
    {
        this.keyCode = keyCode;
        this.interval = interval;
        this.runnable = runnable;
    }

    public float getInterval()
    {
        return interval;
    }

    public int getKeyCode()
    {
        return keyCode;
    }

    public void run()
    {
        new Thread(runnable).start();
    }
}

public class TurboFireStarter implements KeyListener
{
    private List<TurboFireTask> tasks;

    private Scene scene;

    public TurboFireStarter(Scene scene)
    {
        this.scene = scene;
        tasks = new ArrayList<TurboFireTask>();
    }

    public void addTask(int keyCode, float interval, Runnable runnable)
    {
        tasks.add(new TurboFireTask(keyCode, interval, runnable));
    }

    @Override
    public void onKeyDown(KeyEvent e)
    {
        for (TurboFireTask fire : tasks)
        {
            if (e.getKeyCode() == fire.getKeyCode())
            {
                new TurboFireExecutor(scene, fire);
            }
        }
    }
}
