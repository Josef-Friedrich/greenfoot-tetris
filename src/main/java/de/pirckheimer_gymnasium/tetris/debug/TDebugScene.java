package de.pirckheimer_gymnasium.tetris.debug;

import rocks.friedrich.engine_omega.actor.Text;
import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;
import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.*;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class TDebugScene extends Scene implements KeyListener
{
    public boolean DEBUG = false;

    private Text rotation;

    Tetromino tetromino;

    BlockGrid grid;

    public TDebugScene()
    {
        rotation = new Text("0", 1);
        rotation.setColor(Color.WHITE);
        rotation.setPosition(0, 0);
        grid = new BlockGrid(8, 8);
        getCamera().setPostion(4, 4);
        add(rotation);
        tetromino = Tetromino.create(this, grid, "J", 3, 3, DEBUG);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_LEFT:
            tetromino.moveLeft();
            break;

        case KeyEvent.VK_RIGHT:
            tetromino.moveRight();
            break;

        case KeyEvent.VK_DOWN:
            tetromino.moveDown();
            break;

        case KeyEvent.VK_SPACE:
            tetromino.rotate();
            rotation.setContent(tetromino.rotation + "");
            break;
        }
        grid.print();
    }

    public static void main(String[] args)
    {
        TDebugScene scene = new TDebugScene();
        Game.start(Tetris.SCALE * Tetris.BLOCK_SIZE * 8,
                Tetris.SCALE * Tetris.BLOCK_SIZE * 8, scene);
    }
}
