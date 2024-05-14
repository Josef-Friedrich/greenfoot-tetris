package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

public class TypeWriterDebugScene extends Scene implements KeyListener {


    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_L:
            break;


        }
    }
}
