import java.awt.*;

public class Diamond extends Suit {

	public Diamond() {

	}

	public Diamond(int nWidth, int nHeight, int nCentreX, int nCentreY, Color nColor) {
		setWidth(nWidth);
		setHeight(nHeight);
		setCenter(nCentreX, nCentreY);
		setColor(nColor);
	}

	public void draw(Graphics g) {
		int pointsX[] = new int[4];
		int pointsY[] = new int[4];
		int height = getHeight();
		int width = getWidth();
		int centerX = getCenterX();
		int centerY = getCenterY();

		pointsX[0] = centerX - width / 2;
		pointsY[0] = centerY;
		pointsX[1] = centerX;
		pointsY[1] = centerY - height / 2;
		pointsX[2] = centerX + width / 2;
		pointsY[2] = centerY;
		pointsX[3] = centerX;
		pointsY[3] = centerY + height / 2;

		g.setColor(getColor());
		g.fillPolygon(pointsX, pointsY, 4);
	}
}
