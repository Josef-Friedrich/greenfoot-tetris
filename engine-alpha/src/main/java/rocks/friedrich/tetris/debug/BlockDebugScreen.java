package rocks.friedrich.tetris.debug;

import java.awt.event.KeyEvent;

import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;
import rocks.friedrich.tetris.blocks.Block;

public class BlockDebugScreen extends Scene implements KeyListener {

    Block block;

    public BlockDebugScreen() {
        block = new Block(this, "J", 0, 0);
    }

    public static void main(String[] args) {
        Scene scene = new BlockDebugScreen();
        // 160x144 x4 -> 640x576
        Game.setDebug(true);
        Game.start(640, 576, scene);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
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
