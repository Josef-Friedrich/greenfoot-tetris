package rocks.friedrich.tetris;

import ea.Scene;
import ea.actor.Image;

public class TitleScreen extends Scene {
    public TitleScreen() {
        Image image = new Image("images/Title-Screen.png", 16);
        add(image);
    }
}
