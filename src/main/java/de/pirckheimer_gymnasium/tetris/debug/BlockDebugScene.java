package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.tetrominos.Block;
import de.pirckheimer_gymnasium.tetris.tetrominos.BlockGrid;
import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

public class BlockDebugScene extends Scene implements KeyListener
{
    Block block;

    public BlockDebugScene()
    {
        block = new Block(this, new BlockGrid(Tetris.WIDTH, Tetris.HEIGHT), "J",
                Tetris.WIDTH / 2, Tetris.HEIGHT / 2);
    }

    public static void main(String[] args)
    {
        Scene scene = new BlockDebugScene();
        scene.getCamera().setPostion(Tetris.WIDTH / 2, Tetris.HEIGHT / 2);
        Game.setDebug(true);
        Tetris.start(scene);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_LEFT:
            block.moveLeft();
            break;

        case KeyEvent.VK_RIGHT:
            block.moveRight();
            break;

        case KeyEvent.VK_DOWN:
            block.moveDown();
            break;
        }
    }
}
