package de.pirckheimer_gymnasium.tetris.scenes;

import de.pirckheimer_gymnasium.engine_pi.Jukebox;

/**
 * @author Josef Friedrich
 */
public class Sound
{
    public static void playMusic(String filename)
    {
        Jukebox.playMusic("sounds/" + filename);
    }

    public static void playSound(String filename)
    {
        Jukebox.playSound("sounds/" + filename);
    }

    public static void playKorobeiniki()
    {
        playMusic("Korobeiniki.mp3");
    }

    public static void playBlockMove()
    {
        playSound("Block_move.mp3");
    }

    public static void playBlockRotate()
    {
        playSound("Block_rotate.mp3");
    }

    public static void playBlockDrop()
    {
        playSound("Block_drop.mp3");
    }
}
