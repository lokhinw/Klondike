import java.awt.*;
import java.util.*;
import hsa.Console;

public class Deck extends Shape {
	protected Vector deck = new Vector(0, 1);

	public Deck() {
		setSize(120);
		setCenter(100, 100);
		setColor(Color.BLACK);
	}

	public Deck(char deckType) {
		setSize(120);
		setCenter(100, 100);
		setColor(Color.BLACK);

		if (deckType == 's') {
			for (int i = 1; i <= 13; i++) {
				for (int j = 1; j <= 4; j++) {
					Card card = new Card(i, j);
					card.setFaceUp(false);
					addCard(card, 0);
				}
			}
		}
	}

	public void setSize(int nSize) {
		super.setHeight(nSize);
		super.setWidth((int) (Math.round(nSize * 0.7)));
	}

	public void addCard(Card cardToAdd) {
		deck.addElement(cardToAdd);
	}

	public void addCard(Card cardToAdd, int Pos) {
		if (Pos == 0 || deck.size() == 0) {
			deck.addElement(cardToAdd);
		} else if (Pos > deck.size()) {
			deck.insertElementAt(cardToAdd, deck.size());
		} else {
			deck.insertElementAt(cardToAdd, Pos);
		}
	}

	public void removeTopCard() {
		if (deck.size() > 0) {
			deck.removeElement(deck.lastElement());
		}
	}

	public void removeBottomCard() {
		if (deck.size() > 0) {
			deck.removeElement(deck.firstElement());
		}
	}

	public void removeCard(int Pos) {
		if (deck.size() > 0) {
			deck.remove(Pos);
		}
	}

	public void flipTopCard() {
		if (deck.size() > 0) {
			Card card = (Card) deck.lastElement();
			card.setFaceUp(!card.getFaceUp());
			deck.set(deck.size() - 1, card);
		}
	}

	public void flipBottomCard() {
		if (deck.size() > 0) {
			Card card = (Card) deck.lastElement();
			card.setFaceUp(!card.getFaceUp());
			deck.set(0, card);
		}
	}

	public void flipCard(int Pos) {
		if (deck.size() > 0) {
			Card card = (Card) deck.lastElement();
			card.setFaceUp(!card.getFaceUp());
			deck.set(Pos, card);
		}
	}

	public Card getTopCard() {
		return (Card) deck.lastElement();
	}

	public Card getBottomCard() {
		return (Card) deck.firstElement();
	}

	public Card getCard(int Pos) {
		return (Card) deck.elementAt(Pos);
	}

	public int getLength() {
		return deck.size();
	}

	public void shuffle() {
		if (deck.size() > 0) {
			Collections.shuffle(deck);
		}
	}
	
	public void reverse() {
		if (deck.size() > 0) {
			Collections.reverse(deck);
		}
	}

	public void draw(Graphics g) {
		if (deck.size() > 0) {
			Card card = (Card) deck.lastElement();
			card.setCenter(getCenterX(), getCenterY());
			card.setColor(getColor());
			card.setSize(getHeight());
			card.draw(g);
		}
	}

	public void draw(Graphics g, char deckType) {
		if (deck.size() > 0) {
			if (deckType == 's') {
				for (int i = 0; i < Math.ceil((float) deck.size()) / 3; i++) {
					Card card = (Card) deck.lastElement();
					card.setCenter(getCenterX() - i, getCenterY() - i);
					card.setColor(getColor());
					card.setSize(getHeight());
					card.draw(g);
				}
			}

			if (deckType == 'h') {
				for (int i = 0; i < deck.size(); i++) {
					Card card = (Card) getCard(i);
					card.setCenter(getCenterX(), getCenterY() + (i * 30));
					card.setColor(getColor());
					card.setSize(getHeight());
					card.draw(g);
				}
			}
		}
	}

	public void erase(Console c) {
		c.setColor(Color.WHITE);
		c.fillRect(getCenterX() - getWidth() / 2, getCenterY() - getHeight() / 2, getWidth() + 1, getHeight() + 1);
		c.setColor(getColor());
	}

	public void erase(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(getCenterX() - getWidth() / 2, getCenterY() - getHeight() / 2, getWidth() + 1, getHeight() + 1);
		g.setColor(getColor());
	}
}
