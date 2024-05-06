package de.pirckheimer_gymnasium.tetris.tetrominos;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Scene;

public class Block
{
    /**
     * Eine Referenz auf die Szene, in der der Block angezeigt werden soll.
     *
     * <p>
     * Wird benötigen diese Referenz, um den Block in die Szene einzufügen
     * ({@link Scene#add}) bzw. aus der Szene zu entfernen
     * ({@link Scene#remove}).
     */
    private Scene scene;

    private Image image;

    private int x;

    private int y;

    /**
     * @param scene     Eine Referenz auf die Szene, in der der Block angezeigt
     *                  werden soll.
     * @param imageName Das Hauptbild angegeben als Dateiname ohne die
     *                  Dateierweiterung, z. B. {@code "L"} oder
     *                  {@code "I_h_left"}.
     * @param x         Die X-Koordinate der Startposition, auf die der Block
     *                  gesetzt werden soll.
     * @param y         Die Y-Koordinate der Startposition, auf die der Block
     *                  gesetzt werden soll.
     */
    public Block(Scene scene, String imageName, int x, int y)
    {
        this.scene = scene;
        image = new Image("blocks/" + imageName + ".png");
        image.setPosition(x, y);
        scene.add(image);
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void moveBy(int dX, int dY)
    {
        image.moveBy(dX, dY);
        x = x + dX;
        y = y + dY;
    }

    public void moveLeft()
    {
        moveBy(-1, 0);
    }

    public void moveRight()
    {
        moveBy(1, 0);
    }

    public void moveDown()
    {
        moveBy(0, -1);
    }

    public void remove()
    {
        scene.remove(image);
    }
}
