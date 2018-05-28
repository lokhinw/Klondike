import java.awt.*;

public class Waste extends Deck {
	private int currentPosX, currentPosY;

	public Waste() {
		currentPosX = 0;
		currentPosY = 0;
	}

	public void setCurrentPosition(int x, int y) {
		currentPosX = x;
		currentPosY = y;
	}

	public int getCurrentPositionX() {
		return currentPosX;
	}

	public int getCurrentPositionY() {
		return currentPosY;
	}

	public boolean isPointInside(int x, int y) {
		if (x >= currentPosX - getWidth() / 2 && x <= currentPosX + getWidth() / 2 && y >= currentPosY - getHeight() / 2
				&& y <= currentPosY + getHeight() / 2) {
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < deck.size(); i++) {
			Card card = (Card) getCard(i);
			if (i == deck.size() - 1) {
				card.setCenter(currentPosX, currentPosY);
			} else {
				card.setCenter(getCenterX() + (i * 30), getCenterY());
			}
			card.setColor(getColor());
			card.setSize(getHeight());
			card.draw(g);
		}
	}
}
