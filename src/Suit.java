import java.awt.*;
import hsa.Console;

public abstract class Suit extends Shape
{
    public void setWidth (int nWidth)
    {
	super.setHeight ((int) (Math.round (nWidth / 0.8)));
	super.setWidth (nWidth);
    }


    public void setHeight (int nHeight)
    {
	super.setHeight (nHeight);
	super.setWidth ((int) (Math.round (nHeight * 0.8)));
    }
}
