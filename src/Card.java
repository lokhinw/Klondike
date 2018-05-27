import java.awt.*;
import hsa.Console;

public class Card extends Shape {
	private int faceValue, suit, size;
	private boolean faceUp;
	private char[] cardValues = new char[] { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };

	public Card() {
		setSize(120);
		setCenter(100, 100);
		setFaceValue(1);
		setSuit(1);
		setFaceUp(true);
		setColor(Color.BLACK);
	}

	public Card(int nFaceValue, int nSuit) {
		setSize(120);
		setCenter(100, 100);
		setFaceValue(nFaceValue);
		setSuit(nSuit);
		setFaceUp(true);
		setColor(Color.BLACK);
	}

	public Card(int nSize, int nCentreX, int nCentreY, int nFaceValue, int nSuit, boolean nFace, Color nColor) {
		setSize(nSize);
		setCenter(nCentreX, nCentreY);
		if (nFaceValue >= 1 && nFaceValue <= 13) {
			setFaceValue(nFaceValue);
		} else {
			setFaceValue(1);
		}
		if (nSuit >= 1 && nSuit <= 4) {
			setSuit(nSuit);
		} else {
			setSuit(1);
		}
		setFaceUp(nFace);
		setColor(nColor);
	}

	public void setFaceValue(int nFaceValue) {
		if (nFaceValue >= 1 && nFaceValue <= 13) {
			faceValue = nFaceValue;
		}
	}

	public void setSuit(int nSuit) {
		if (nSuit >= 1 && nSuit <= 4) {
			suit = nSuit;
		}
	}

	public void setSize(int nSize) {
		super.setHeight(nSize);
		super.setWidth((int) (Math.round(nSize * 0.7)));
	}

	public void setFaceUp(boolean nFace) {
		faceUp = nFace;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public int getSuit() {
		return suit;
	}

	public boolean getFaceUp() {
		return faceUp;
	}

	public void draw(Graphics g) {
		int height = getHeight();
		int width = getWidth();
		int centerX = getCenterX();
		int centerY = getCenterY();
		Font cardFont = new Font("Palatino", Font.BOLD, (int) (Math.round(height * 0.17)));

		if (faceUp) {
			g.setColor(Color.WHITE);
			g.fillRoundRect(centerX - width / 2, centerY - height / 2, width, height, 5, 5);
			g.setColor(Color.BLACK);
			g.drawRoundRect(centerX - width / 2 - 1, centerY - height / 2 - 1, width, height, 5, 5);

			if (suit == 1) {
				Spade spade = new Spade();
				spade.setCenter(centerX, centerY);
				spade.setHeight((int) (Math.round(height * 0.25)));
				spade.setColor(Color.BLACK);
				spade.draw(g);
			} else if (suit == 2) {
				Diamond diamond = new Diamond();
				diamond.setCenter(centerX, centerY);
				diamond.setHeight((int) (Math.round(height * 0.25)));
				diamond.setColor(Color.RED);
				diamond.draw(g);
			} else if (suit == 3) {
				Club club = new Club();
				club.setCenter(centerX, centerY);
				club.setHeight((int) (Math.round(height * 0.25)));
				club.setColor(Color.BLACK);
				club.draw(g);
			} else if (suit == 4) {
				Heart heart = new Heart();
				heart.setCenter(centerX, centerY);
				heart.setHeight((int) (Math.round(height * 0.25)));
				heart.setColor(Color.RED);
				heart.draw(g);
			}
			g.setFont(cardFont);
			g.drawString(String.valueOf(cardValues[faceValue - 1]), centerX - width / 2 + width / 16,
					centerY - height / 3);
		} else {
			g.setColor(getColor());
			g.fillRoundRect(centerX - width / 2, centerY - height / 2, width, height, 5, 5);
			g.setColor(Color.BLACK);
			g.drawRoundRect(centerX - width / 2, centerY - height / 2 - 1, width - 1, height, 5, 5);
		}
		g.setColor(getColor());
	}
}
