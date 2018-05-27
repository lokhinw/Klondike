import java.awt.*;
import hsa.Console;

public class Club extends Suit {

	public Club() {

	}

	public Club(int nWidth, int nHeight, int nCentreX, int nCentreY, Color nColor) {
		setWidth(nWidth);
		setHeight(nHeight);
		setCenter(nCentreX, nCentreY);
		setColor(nColor);
	}

	public void draw(Graphics g) {
		int pointsX[] = new int[5];
		int pointsY[] = new int[5];
		int triPointsX[] = new int[3];
		int triPointsY[] = new int[3];
		int height = getHeight();
		int width = getWidth();
		int centerX = getCenterX();
		int centerY = getCenterY();

		pointsX[0] = centerX - width / 2;
		pointsY[0] = centerY;
		pointsX[1] = centerX + width / 2;
		pointsY[1] = centerY;
		pointsX[2] = centerX;
		pointsY[2] = centerY - height / 2;
		pointsX[3] = centerX - width / 2;
		pointsY[3] = centerY - height / 4;
		pointsX[4] = centerX;
		pointsY[4] = centerY - height / 4;

		triPointsX[0] = centerX;
		triPointsY[0] = centerY - height / 4;
		triPointsX[1] = centerX - width / 8;
		triPointsY[1] = centerY + height / 2;
		triPointsX[2] = centerX + width / 8;
		triPointsY[2] = centerY + height / 2;

		g.setColor(getColor());
		g.fillOval(pointsX[3], pointsY[3], width / 2, height / 2);
		g.fillOval(pointsX[4], pointsY[4], width / 2, height / 2);
		g.fillOval(centerX - width / 4, centerY - 4 * (height / 7), width / 2, height / 2);
		g.fillPolygon(triPointsX, triPointsY, 3);
	}
}
