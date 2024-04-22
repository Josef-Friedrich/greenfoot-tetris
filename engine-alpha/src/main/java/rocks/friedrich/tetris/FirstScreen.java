package rocks.friedrich.tetris;

import ea.Scene;
import ea.actor.Image;

public class FirstScreen extends Scene {

    public FirstScreen() {
        Image image = new Image("images/First-Screen.png", 32);
        image.setPosition(0, 0);
        add(image);
        getCamera().setPostion(10, 9);
    }

}
