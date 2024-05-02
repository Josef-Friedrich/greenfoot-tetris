package de.pirckheimer_gymnasium.tetris.tetrominos;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.Vector;

public class Block
{
    private Image image;

    private String name;

    private Vector motion;

    /**
     * Eine Referenz auf die Szene, in der der Block angezeigt werden soll.
     *
     * <p>
     * Wird benötigen diese Referenz, um den Block in die Szene einzufügen
     * ({@link Scene#add}) bzw. aus der Szene zu entfernen
     * ({@link Scene#remove}).
     */
    private Scene scene;

    /**
     * @param scene Eine Referenz auf die Szene, in der der Block angezeigt
     *              werden soll.
     * @param name  Der Name des Blocks entspricht dem Dateinamen des Bildes
     *              ohne die Dateierweiterung, z. B. {@code "L"} oder
     *              {@code "I_left"}.
     * @param x     Die X-Koordinate der Startposition, auf die der Block
     *              gesetzt werden soll.
     * @param y     Die Y-Koordinate der Startposition, auf die der Block
     *              gesetzt werden soll.
     */
    public Block(Scene scene, String name, int x, int y)
    {
        this.scene = scene;
        this.name = name;
        image = new Image("blocks/" + name + ".png");
        image.setPosition(x, y);
        scene.add(image);
    }

    /**
     * Gibt den Namen des Blocks zurück.
     *
     * @return Der Name des Blocks z. B. {@code "L"} oder {@code "I_left"}.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gibt den ersten Buchstaben des Blocknamens zurück.
     *
     * @return Der erste Buchstaben des Blocknamens des Blocks z. B. {@code 'L'}
     *         oder {@code 'I'}.
     */
    public char getChar()
    {
        return name.charAt(0);
    }

    public int getX()
    {
        return (int) image.getX();
    }

    public int getY()
    {
        return (int) image.getY();
    }

    public void moveBy(int dX, int dY)
    {
        image.moveBy(dX, dY);
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

    public void rotateCounterClockwise()
    {
        image.rotateBy(90);
    }

    public void rotateClockwise()
    {
        image.rotateBy(-90);
    }

    public void setMotion(Vector motion)
    {
        this.motion = motion;
    }

    public void resetMotion()
    {
        this.motion = null;
    }

    public void setMotion(float dX, float dY)
    {
        motion = new Vector(dX, dY);
    }

    public Vector getMotion()
    {
        return motion;
    }

    public Vector getMotionDestination()
    {
        if (motion == null)
        {
            return null;
        }
        return image.getPosition().add(motion);
    }

    public void move()
    {
        if (motion != null)
        {
            image.moveBy(this.motion);
            motion = null;
        }
    }
}
