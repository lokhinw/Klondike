import java.awt.Graphics;

public class Tableau extends Deck {
	private int currentPosX, currentPosY;

	public Tableau() {
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
		for (int i = 0; i < deck.size(); i++) {
			Card card = (Card) getCard(i);
			card.setCenter(getCenterX(), getCenterY() + (i * 30));
			card.setColor(getColor());
			card.setSize(getHeight());
			card.draw(g);
		}
	}
}
