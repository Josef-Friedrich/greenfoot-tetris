package rocks.friedrich.tetris.color;

import java.awt.Color;

public class GrayColorSchema2 implements ColorSchema
{
    public Color white()
    {
        return new Color(255, 255, 255);
    }

    public Color light()
    {
        // #f8f8f8
        return new Color(248, 248, 248);
    }

    public Color dark()
    {
        // #a8a8a8
        return new Color(168, 168, 168);
    }

    public Color black()
    {
        return new Color(0, 0, 0);
    }
}
