import java.awt.*;
import hsa.Console;

public class Spade extends Suit
{
    public Spade ()
    {

    }


    public Spade (int nWidth, int nHeight, int nCentreX, int nCentreY, Color nColor)
    {
	setWidth (nWidth);
	setHeight (nHeight);
	setCenter (nCentreX, nCentreY);
	setColor (nColor);
    }


    public void draw (Console c)
    {
	int pointsX[] = new int [5];
	int pointsY[] = new int [5];
	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];
	int height = getHeight ();
	int width = getWidth ();
	int centerX = getCenterX ();
	int centerY = getCenterY ();

	pointsX [0] = centerX - width / 2;
	pointsY [0] = centerY;
	pointsX [1] = centerX + width / 2;
	pointsY [1] = centerY;
	pointsX [2] = centerX;
	pointsY [2] = centerY - height / 2;
	pointsX [3] = centerX - width / 2;
	pointsY [3] = centerY - height / 4;
	pointsX [4] = centerX;
	pointsY [4] = centerY - height / 4;

	triPointsX [0] = centerX;
	triPointsY [0] = centerY;
	triPointsX [1] = centerX - width / 8;
	triPointsY [1] = centerY + height / 2;
	triPointsX [2] = centerX + width / 8;
	triPointsY [2] = centerY + height / 2;

	c.setColor (getColor ());
	c.fillArc (pointsX [3], pointsY [3], width / 2, height / 2, 180, 180);
	c.fillArc (pointsX [4], pointsY [4], width / 2, height / 2, 180, 180);
	c.fillPolygon (pointsX, pointsY, 3);
	c.fillPolygon (triPointsX, triPointsY, 3);
    }


    public void draw (Graphics g)
    {
	int pointsX[] = new int [5];
	int pointsY[] = new int [5];
	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];
	int height = getHeight ();
	int width = getWidth ();
	int centerX = getCenterX ();
	int centerY = getCenterY ();

	pointsX [0] = centerX - width / 2;
	pointsY [0] = centerY;
	pointsX [1] = centerX + width / 2;
	pointsY [1] = centerY;
	pointsX [2] = centerX;
	pointsY [2] = centerY - height / 2;
	pointsX [3] = centerX - width / 2;
	pointsY [3] = centerY - height / 4;
	pointsX [4] = centerX;
	pointsY [4] = centerY - height / 4;

	triPointsX [0] = centerX;
	triPointsY [0] = centerY;
	triPointsX [1] = centerX - width / 8;
	triPointsY [1] = centerY + height / 2;
	triPointsX [2] = centerX + width / 8;
	triPointsY [2] = centerY + height / 2;

	g.setColor (getColor ());
	g.fillArc (pointsX [3], pointsY [3], width / 2, height / 2, 180, 180);
	g.fillArc (pointsX [4], pointsY [4], width / 2, height / 2, 180, 180);
	g.fillPolygon (pointsX, pointsY, 3);
	g.fillPolygon (triPointsX, triPointsY, 3);
    }
}
