import greenfoot.GreenfootSound;

public class SoundPlayer {
    private static GreenfootSound korobeiniki = new GreenfootSound("korobeiniki.wav");
    private static GreenfootSound blockDrop = new GreenfootSound("block-drop.wav");
    private static GreenfootSound blockRotate = new GreenfootSound("block-rotate.wav");

    private static GreenfootSound blockMove = new GreenfootSound("block-move.wav");

    public static void playKorobeiniki() {
            korobeiniki.playLoop();

    }

    public static void playBlockDrop() {
            blockDrop.play();

    }

    public static void playBlockRotate() {
            blockRotate.play();

    }

    public static void playBlockMove() {
            blockMove.play();

    }
}
