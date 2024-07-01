package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.engine_pi.Game;
import de.pirckheimer_gymnasium.engine_pi.Resources;
import de.pirckheimer_gymnasium.engine_pi.sound.LoopedTrack;

/**
 * @author Josef Friedrich
 */
public class Sound
{
    private static void playMusic(String filename)
    {
        try
        {

            Game.getJukebox().playMusic(new LoopedTrack(Resources.SOUNDS.get("sounds/" + filename)));
        }
        catch (Exception e)
        {
            // e.printStackTrace();
        }
    }

    private static void playSound(String filename)
    {
        try
        {
            Game.getJukebox().playSound("sounds/" + filename);
        }
        catch (Exception e)
        {
            // e.printStackTrace();
        }
    }

    public static void korobeiniki()
    {
        playMusic("Korobeiniki.mp3");
    }

    public static void blockMove()
    {
        playSound("Block_move.mp3");
    }

    public static void blockRotate()
    {
        playSound("Block_rotate.mp3");
    }

    public static void blockDrop()
    {
        playSound("Block_drop.mp3");
    }
}
