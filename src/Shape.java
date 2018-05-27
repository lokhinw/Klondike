import java.awt.*;
import hsa.Console;

public abstract class Shape
{
    protected int width, height, centerX, centerY;
    protected Color color;

    public abstract void draw (Console c);
    public abstract void draw (Graphics g);

    public void setWidth (int nWidth)
    {
	width = nWidth;
    }


    public void setHeight (int nHeight)
    {
	height = nHeight;
    }


    public void setCenter (int nCenterX, int nCenterY)
    {
	centerX = nCenterX;
	centerY = nCenterY;
    }


    public void setColor (Color nColor)
    {
	color = nColor;
    }



    public int getWidth ()
    {
	return width;
    }


    public int getHeight ()
    {
	return height;
    }


    public int getCenterX ()
    {
	return centerX;
    }


    public int getCenterY ()
    {
	return centerY;
    }


    public Color getColor ()
    {
	return color;
    }


    public void delay (int iDelayTime)
    {
	long lFinalTime = System.currentTimeMillis () + iDelayTime;
	do
	{
	}
	while (lFinalTime >= System.currentTimeMillis ());
    }

    public boolean isPointInside (int x, int y)
    {
        if (x >= getCenterX () - getWidth () / 2 && x <= getCenterX () + getWidth () / 2 && y >= getCenterY () - getHeight () / 2 && y <= getCenterY () + getHeight () / 2)
        {
            return true;
        }
        return false;
    }

    public void erase (Console c)
    {
	Color cOldColor = getColor ();
	setColor (Color.WHITE);
	draw (c);
	setColor (cOldColor);
    }


    public void erase (Graphics g)
    {
	Color cOldColor = getColor ();
	setColor (Color.WHITE);
	draw (g);
	setColor (cOldColor);
    }
}

