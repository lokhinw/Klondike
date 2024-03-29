import java.awt.*;

public abstract class Shape {
	protected int width, height, centerX, centerY;
	protected Color color;
	protected boolean draggable = false;

	public abstract void draw(Graphics g);

	public void setWidth(int nWidth) {
		width = nWidth;
	}

	public void setHeight(int nHeight) {
		height = nHeight;
	}

	public void setCenter(int nCenterX, int nCenterY) {
		centerX = nCenterX;
		centerY = nCenterY;
	}

	public void setColor(Color nColor) {
		color = nColor;
	}

	public void setDraggable(boolean nDraggable) {
		draggable = nDraggable;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Color getColor() {
		return color;
	}

	public boolean isDraggable() {
		return draggable;
	}

	public void delay(int iDelayTime) {
		long lFinalTime = System.currentTimeMillis() + iDelayTime;
		do {
		} while (lFinalTime >= System.currentTimeMillis());
	}

	public boolean isPointInside(int x, int y) {
		if (x >= getCenterX() - getWidth() / 2 && x <= getCenterX() + getWidth() / 2
				&& y >= getCenterY() - getHeight() / 2 && y <= getCenterY() + getHeight() / 2) {
			return true;
		}
		return false;
	}

	public void erase(Graphics g) {
		Color cOldColor = getColor();
		setColor(Color.WHITE);
		draw(g);
		setColor(cOldColor);
	}
}
