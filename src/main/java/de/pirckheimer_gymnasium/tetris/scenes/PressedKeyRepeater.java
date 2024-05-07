package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import rocks.friedrich.engine_omega.FrameUpdateListener;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

/**
 * Bei gedrückter Taste mehrmals die gleiche Aktionen in einem bestimmten
 * Abstand ausführen.
 */
public class PressedKeyRepeater implements KeyListener
{
    private List<Task> tasks;

    private Scene scene;

    private class Executor implements FrameUpdateListener, KeyListener
    {
        private double countdown;

        private Task task;

        public Executor(Task task)
        {
            this.task = task;
            countdown = task.getFirstRepeatDelay();
            scene.addKeyListener(this);
            scene.addFrameUpdateListener(this);
            task.run();
        }

        @Override
        public void onFrameUpdate(float deltaSeconds)
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

        private double interval;

        private Runnable runnable;

        /**
         * Verzögerung zwischen dem Tastendruck und der ersten Wiederholung der
         * Aufgabe.
         */
        private double firstRepeatDelay;

        public Task(int keyCode, double interval, Runnable runnable,
                double firstRepeatDelay)
        {
            this.keyCode = keyCode;
            this.interval = interval;
            this.runnable = runnable;
            this.firstRepeatDelay = firstRepeatDelay;
        }

        public int getKeyCode()
        {
            return keyCode;
        }

        public double getInterval()
        {
            return interval;
        }

        public void run()
        {
            new Thread(runnable).start();
        }

        public double getFirstRepeatDelay()
        {
            if (firstRepeatDelay == 0)
            {
                return interval;
            }
            return firstRepeatDelay;
        }
    }

    public PressedKeyRepeater(Scene scene)
    {
        this.scene = scene;
        tasks = new ArrayList<Task>();
    }

    public void addTask(int keyCode, double interval, Runnable runnable,
            double initialRepeatDelay)
    {
        tasks.add(new Task(keyCode, interval, runnable, initialRepeatDelay));
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
