package de.pirckheimer_gymnasium.tetris.debug;

import java.awt.Color;

import de.pirckheimer_gymnasium.tetris.Tetris;
import de.pirckheimer_gymnasium.tetris.text.TextField;
import rocks.friedrich.engine_omega.Scene;

public class TextFieldDebugScene extends Scene
{
    public TextFieldDebugScene()
    {
        TextField textField = new TextField(this, 0, 8, 5, 20);
        getCamera().setPostion(10, 8);
        textField.write("Hello, World. Lorem ipsum. Lorem ipsum. Lorem ipsum",
                Tetris.COLOR_SCHEME_GREEN.getDark());
        setBackgroundColor(Color.GRAY);
    }

    public static void main(String[] args)
    {
        Tetris.start(new TextFieldDebugScene(), true);
    }
}
