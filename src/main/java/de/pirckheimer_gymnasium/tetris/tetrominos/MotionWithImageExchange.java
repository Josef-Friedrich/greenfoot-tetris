package de.pirckheimer_gymnasium.tetris.tetrominos;

class MotionWithImageExchange extends Motion
{
    private boolean exchangeImage;

    public MotionWithImageExchange(int x, int y, boolean exchangeImage)
    {
        super(x, y);
        this.exchangeImage = exchangeImage;
    }

    public boolean exchangeImage()
    {
        return exchangeImage;
    }
}
