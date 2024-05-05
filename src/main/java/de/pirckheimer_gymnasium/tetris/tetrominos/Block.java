package de.pirckheimer_gymnasium.tetris.tetrominos;

import de.pirckheimer_gymnasium.tetris.Image;
import rocks.friedrich.engine_omega.Scene;
import rocks.friedrich.engine_omega.Vector;

public class Block
{
    private Image image;

    private Image mainImage;

    private Image secondImage;

    private String name;

    private Vector position;

    private MotionWithImageExchange motion;

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
     * @param scene       Eine Referenz auf die Szene, in der der Block
     *                    angezeigt werden soll.
     * @param mainImage   Das Hauptbild angegeben als Dateiname ohne die
     *                    Dateierweiterung, z. B. {@code "L"} oder
     *                    {@code "I_h_left"}.
     * @param secondImage Das zweite Bild angegeben als Dateiname ohne die
     *                    Dateierweiterung, z. B. {@code "L"} oder
     *                    {@code "I_v_bottom"}.
     * @param x           Die X-Koordinate der Startposition, auf die der Block
     *                    gesetzt werden soll.
     * @param y           Die Y-Koordinate der Startposition, auf die der Block
     *                    gesetzt werden soll.
     */
    public Block(Scene scene, String mainImage, String secondImage, int x,
            int y)
    {
        this.scene = scene;
        name = mainImage;
        image = new Image("blocks/" + mainImage + ".png");
        if (secondImage != null)
        {
            this.secondImage = new Image("blocks/" + secondImage + ".png");
        }
        image.setPosition(x, y);
        position = new Vector(x, y);
        scene.add(image);
    }

    /**
     * @param scene Eine Referenz auf die Szene, in der der Block angezeigt
     *              werden soll.
     * @param name  Der Name des Blocks entspricht dem Dateinamen des Bildes
     *              ohne die Dateierweiterung, z. B. {@code "L"} oder
     *              {@code "I_h_left"}.
     * @param x     Die X-Koordinate der Startposition, auf die der Block
     *              gesetzt werden soll.
     * @param y     Die Y-Koordinate der Startposition, auf die der Block
     *              gesetzt werden soll.
     */
    public Block(Scene scene, String name, int x, int y)
    {
        this(scene, name, null, x, y);
    }

    /**
     * Gibt den Namen des Blocks zurück.
     *
     * @return Der Name des Blocks z. B. {@code "L"} oder {@code "I_h_left"}.
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

    public void moveBy(Vector vector)
    {
        image.moveBy(vector);
        position = position.add(vector);
    }

    public void moveBy(int dX, int dY)
    {
        moveBy(new Vector(dX, dY));
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

    public void exchangeImages()
    {
        if (image != null && mainImage != null)
        {
            image.remove();
            secondImage = image;
            image = mainImage;
            scene.add(image);
            image.setPosition(position);
            mainImage = null;
        }
        else if (image != null && secondImage != null)
        {
            image.remove();
            mainImage = image;
            image = secondImage;
            scene.add(image);
            image.setPosition(position);
            secondImage = null;
        }
    }

    public void setMotion(MotionWithImageExchange motion)
    {
        this.motion = motion;
    }

    public void resetMotion()
    {
        this.motion = null;
    }

    public void setMotion(int dX, int dY, boolean switchImage)
    {
        motion = new MotionWithImageExchange(dX, dY, switchImage);
    }

    public void setMotion(int dX, int dY)
    {
        setMotion(dX, dY, false);
    }

    public Motion getMotion()
    {
        return motion;
    }

    public Vector getMotionDestination()
    {
        if (motion == null)
        {
            return null;
        }
        return position.add(motion.getVector());
    }

    public void move()
    {
        if (motion != null)
        {
            if (motion.exchangeImage())
            {
                exchangeImages();
            }
            moveBy(motion.getVector());
            motion = null;
        }
    }
}
