import java.awt.Graphics;

public class Foundation extends Deck {
	private int currentValue, currentSuit;

	// private int currentPosX, currentPosY;
	//
	// public Waste() {
	// currentPosX = 0;
	// currentPosY = 0;
	// }
	//

	public void setCurrentValue(int nCurrentValue) {
		currentValue = nCurrentValue;
	}

	public void setCurrentSuit(int nCurrentSuit) {
		currentSuit = nCurrentSuit;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public int getCurrentSuit() {
		return currentSuit;
	}

	// public void setCurrentPosition(int nCurrentPosX, int nCurrentPosY) {
	// currentPosX = nCurrentPosX;
	// currentPosY = nCurrentPosY;
	// }
	//
	// public int getCurrentPositionX() {
	// return currentPosX;
	// }
	//
	// public int getCurrentPositionY() {
	// return currentPosY;
	// }
	//
	public boolean isValidMove(int x, int y, int value, int suit) {
		if (x >= getCenterX() - getWidth() / 2 && x <= getCenterX() + getWidth() / 2
				&& y >= getCenterY() - getHeight() / 2 && y <= getCenterY() + getHeight() / 2) {
			if (currentValue == 0 && value == 1) {
				currentValue = value;
				currentSuit = suit;
				return true;
			} else if (currentValue + 1 == value && currentSuit == suit) {
				currentValue = value;
				currentSuit = suit;
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < deck.size(); i++) {
			Card card = (Card) getCard(i);
			card.setCenter(getCenterX(), getCenterY());
			card.setColor(getColor());
			card.setSize(getHeight());
			card.draw(g);
		}
	}
}
