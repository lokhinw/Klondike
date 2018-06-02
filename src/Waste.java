import java.awt.*;

public class Waste extends Deck {
	private int currentPosX, currentPosY;

	public Waste() {
		currentPosX = 0;
		currentPosY = 0;
	}

	public void setCurrentPosition(int nCurrentPosX, int nCurrentPosY) {
		currentPosX = nCurrentPosX;
		currentPosY = nCurrentPosY;
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
		if (deck.size() > 3) {
			for (int i = 0; i < 3; i++) {
				Card card = (Card) getCard(deck.size() - 3 + i);
				card.setCenter(getCenterX() + (i * 30), getCenterY());
				card.setColor(getColor());
				card.setSize(getHeight());
				card.draw(g);
			}
		} else {
			for (int i = 0; i < deck.size(); i++) {
				Card card = (Card) getCard(i);
				card.setCenter(getCenterX() + (i * 30), getCenterY());
				card.setColor(getColor());
				card.setSize(getHeight());
				card.draw(g);
			}
		}

	}
}
