package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import rocks.friedrich.engine_omega.event.FrameUpdateListener;
import rocks.friedrich.engine_omega.event.FrameUpdateListenerContainer;
import rocks.friedrich.engine_omega.event.KeyListener;
import rocks.friedrich.engine_omega.event.KeyListenerContainer;

/**
 * Bei gedrückter Taste mehrmals die gleiche Aktionen in einem bestimmten
 * Abstand ausführen.
 */
public class PressedKeyRepeater<T extends KeyListenerContainer & FrameUpdateListenerContainer>
        implements KeyListener
{
    private List<Task> tasks;

    private T scene;

    /**
     * In Sekunden
     */
    private double defaultInterval = 0.03;

    /**
     * In Sekunden
     */
    private double defaultInitialInterval = 0.15;

    private class Executor implements FrameUpdateListener, KeyListener
    {
        private double countdown;

        private Task task;

        public Executor(Task task)
        {
            this.task = task;
            countdown = task.getInitialInterval();
            scene.addKeyListener(this);
            scene.addFrameUpdateListener(this);
            task.run();
        }

        @Override
        public void onFrameUpdate(double deltaSeconds)
        {
            countdown -= deltaSeconds;
            if (countdown < 0)
            {
                task.run();
                countdown = task.getInterval();
            }
        }

        public void onKeyDown(KeyEvent e)
        {
            // Do nothing
        }

        @Override
        public void onKeyUp(KeyEvent e)
        {
            if (e.getKeyCode() == task.getKeyCode())
            {
                scene.removeKeyListener(this);
                scene.removeFrameUpdateListener(this);
            }
        }
    }

    private class Task
    {
        private int keyCode;

        private Runnable runnable;

        /**
         * Verzögerung zwischen dem ersten Tastendruck und der ersten
         * Wiederholung der Aufgabe.
         *
         * In Sekunden
         */
        private double initialInterval;

        /**
         * In Sekunden
         */
        private double interval;

        public Task(int keyCode, Runnable runnable, double interval,
                double initialInterval)
        {
            this.keyCode = keyCode;
            this.interval = interval;
            this.runnable = runnable;
            this.initialInterval = initialInterval;
        }

        public Task(int keyCode, Runnable runnable)
        {
            this.keyCode = keyCode;
            this.runnable = runnable;
        }

        public int getKeyCode()
        {
            return keyCode;
        }

        public double getInterval()
        {
            if (interval == 0)
            {
                return defaultInterval;
            }
            return interval;
        }

        public void run()
        {
            runnable.run();
        }

        public double getInitialInterval()
        {
            if (initialInterval == 0.0)
            {
                return defaultInitialInterval;
            }
            return initialInterval;
        }
    }

    public PressedKeyRepeater(T scene, double interval, double intialInterval)
    {
        this.scene = scene;
        if (interval > 0)
        {
            defaultInterval = interval;
        }
        if (intialInterval > 0)
        {
            defaultInitialInterval = intialInterval;
        }
        tasks = new ArrayList<Task>();
        this.scene.addKeyListener(this);
    }

    public PressedKeyRepeater(T scene)
    {
        this(scene, 0, 0);
    }

    public void addTask(int keyCode, Runnable runnable, double interval,
            double initialInterval)
    {
        tasks.add(new Task(keyCode, runnable, interval, initialInterval));
    }

    public void addTask(int keyCode, Runnable runnable)
    {
        tasks.add(new Task(keyCode, runnable));
    }

    @Override
    public void onKeyDown(KeyEvent e)
    {
        for (Task task : tasks)
        {
            if (e.getKeyCode() == task.getKeyCode())
            {
                new Executor(task);
            }
        }
    }
}
