import java.awt.*;

public class Heart extends Suit {

	public Heart() {

	}

	public Heart(int nWidth, int nHeight, int nCentreX, int nCentreY, Color nColor) {
		setWidth(nWidth);
		setHeight(nHeight);
		setCenter(nCentreX, nCentreY);
		setColor(nColor);
	}

	public void draw(Graphics g) {
		int pointsX[] = new int[5];
		int pointsY[] = new int[5];
		int height = getHeight();
		int width = getWidth();
		int centerX = getCenterX();
		int centerY = getCenterY();

		pointsX[0] = centerX - width / 2;
		pointsY[0] = centerY;
		pointsX[1] = centerX + width / 2;
		pointsY[1] = centerY;
		pointsX[2] = centerX;
		pointsY[2] = centerY + height / 2;
		pointsX[3] = centerX - width / 2;
		pointsY[3] = centerY - height / 4;
		pointsX[4] = centerX;
		pointsY[4] = centerY - height / 4;

		g.setColor(getColor());
		g.fillArc(pointsX[3], pointsY[3], width / 2, height / 2, 0, 180);
		g.fillArc(pointsX[4], pointsY[4], width / 2, height / 2, 0, 180);
		g.fillPolygon(pointsX, pointsY, 3);
	}
}
