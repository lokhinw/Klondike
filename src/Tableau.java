import java.awt.Graphics;

public class Tableau extends Deck {
	private int currentPosX, currentPosY, currentValue;
	private int currentSuit;

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

	public boolean checkSuit(int suit) {
		currentSuit = getTopCard().getSuit();
		if ((currentSuit == 1 || currentSuit == 3) && (suit == 2 || suit == 4)) {
			return true;
		}
		if ((currentSuit == 2 || currentSuit == 4) && (suit == 1 || suit == 3)) {
			return true;
		}
		return false;
	}

	public boolean checkSuit(int suit, Card card) {
		currentSuit = card.getSuit();
		if ((currentSuit == 1 || currentSuit == 3) && (suit == 2 || suit == 4)) {
			return true;
		}
		if ((currentSuit == 2 || currentSuit == 4) && (suit == 1 || suit == 3)) {
			return true;
		}
		return false;
	}

	public int getMaxDrag() {
		int count = 0;
		if (deck.size() > 0) {
			int suit = getTopCard().getSuit();
			int val = getTopCard().getFaceValue();
			for (int i = deck.size() - 2; i >= 0; i--) {
				Card card = (Card) getCard(i);
				if (val + 1 == card.getFaceValue() && card.getFaceUp() && checkSuit(suit, card)) {
					count += 1;
					suit = card.getSuit();
					val = card.getFaceValue();
				} else {
					break;
				}
			}
		}
		return count;
	}

	public boolean isValidMove(int x, int y, int value, int suit) {
		if (x >= currentPosX - getWidth() / 2 && x <= currentPosX + getWidth() / 2 && y >= currentPosY - getHeight() / 2
				&& y <= currentPosY + getHeight() / 2) {
			if (deck.size() > 0) {
				currentValue = getTopCard().getFaceValue();
				if (checkSuit(suit) && currentValue - 1 == value) {
					return true;
				}
			} else if (value == 13) {
				return true;
			}
		}
		return false;
	}

	public boolean isPointInside(int x, int y) {
		if (x >= currentPosX - getWidth() / 2 && x <= currentPosX + getWidth() / 2 && y >= currentPosY - getHeight() / 2
				&& y <= currentPosY + getHeight() / 2) {
			return true;
		}
		return false;
	}

	public boolean isPointInside(int x, int y, int maxDrag) {
		if (x >= currentPosX - getWidth() / 2 && x <= currentPosX + getWidth() / 2
				&& y >= currentPosY - getHeight() / 2 - (maxDrag * 30)
				&& y <= currentPosY + getHeight() / 2 - ((maxDrag - 1) * 30) - 80) {
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
