package de.pirckheimer_gymnasium.tetris.scenes;

import java.awt.event.KeyEvent;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Game;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.event.KeyListener;

public class BaseScene extends Scene implements KeyListener
{
    protected Image background;

    public static Scene SCENE_COPYRIGHT = new CopyrightScene();

    public static Scene SCENE_TITLE = new TitleScene();

    public static Scene SCENE_INGAME = new IngameScene();

    public BaseScene(String imageFilename)
    {
        background = new Image("fullscreen/" + imageFilename + ".png");
        getCamera().setFocus(background);
        add(background);
        addKeyListener(this);
    }

    @Override
    public void onKeyDown(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
        case KeyEvent.VK_1:
            Game.transitionToScene(SCENE_COPYRIGHT);
            break;

        case KeyEvent.VK_2:
            Game.transitionToScene(SCENE_TITLE);
            break;

        case KeyEvent.VK_3:
            Game.transitionToScene(SCENE_INGAME);
            break;
        }
    }
}
