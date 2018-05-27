import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements MouseListener, MouseMotionListener {

	Deck stock = new Deck('s');
	Deck waste = new Deck();
	Deck hand = new Deck();
	Deck[] tableau = new Deck[7];
	Deck[] foundation = new Deck[4];

	final int CARD_HEIGHT = 80;
	final int CARD_WIDTH = 56;

	Graphics g;

	public void init() {

		setSize(500, 550);
		setBackground(new Color(7, 89, 45));
		addMouseListener(this);
		addMouseMotionListener(this);
		stock.setSize(CARD_HEIGHT);
		stock.setCenter(44, 60);
		stock.setColor(Color.ORANGE);

		hand.setSize(CARD_HEIGHT);
		hand.setCenter(114, 60);
		hand.setColor(Color.ORANGE);

		g = getGraphics();
		// stock.shuffle();

		for (int i = 0; i < 7; i++) {
			tableau[i] = new Deck();
			for (int j = 0; j < i + 1; j++) {
				Card card = stock.getTopCard();
				if (i == j) {
					card.setFaceUp(true);
				}
				tableau[i].setSize(CARD_HEIGHT);
				tableau[i].setColor(Color.ORANGE);
				tableau[i].addCard(card);
				stock.removeTopCard();
			}
		}
		for (int i = 0; i < 19; i++) {
			stock.removeTopCard();
		}
	}

	public void paint(Graphics g) {
		g.setColor(new Color(1, 173, 86));
		g.fillRoundRect(16, 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
		g.setColor(new Color(0, 110, 55));
		g.drawRoundRect(16, 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);

		g.setColor(new Color(1, 173, 86));
		g.fillRoundRect(85, 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
		g.setColor(new Color(0, 110, 55));
		g.drawRoundRect(16, 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);

		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(1, 173, 86));
			g.fillRoundRect(223 + (69 * i), 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
			g.setColor(new Color(0, 110, 55));
			g.drawRoundRect(223 + (69 * i), 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			g.setColor(new Color(1, 173, 86));
			g.fillRoundRect(16 + (69 * i), 120, CARD_WIDTH, CARD_HEIGHT, 5, 5);
			g.setColor(new Color(0, 110, 55));
			g.drawRoundRect(16 + (69 * i), 120 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			tableau[i].setCenter(44 + (69 * i), 160);
			tableau[i].draw(g, 't');
		}

		stock.draw(g, 's');
		hand.draw(g, 'w');
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		if (stock.isPointInside(e.getX(), e.getY()) == true) {
			if (hand.getLength() > 0) {
				int j = hand.getLength();
				for (int i = 0; i < j; i++) {
					Card card = hand.getBottomCard();
					waste.addCard(card);
					hand.removeBottomCard();
				}
			}
			if (stock.getLength() == 0) {
				int j = waste.getLength();
				for (int i = 0; i < j; i++) {
					Card card = waste.getTopCard();
					card.setFaceUp(false);
					stock.addCard(card);
					waste.removeTopCard();
				}
			} else {
				if (stock.getLength() >= 3) {
					for (int i = 0; i < 3; i++) {
						Card card = stock.getTopCard();
						card.setFaceUp(true);
						hand.addCard(card);
						stock.removeTopCard();
					}
				} else {
					int j = stock.getLength();
					for (int i = 0; i < j; i++) {
						Card card = stock.getTopCard();
						card.setFaceUp(true);
						hand.addCard(card);
						stock.removeTopCard();
					}
				}
			}
			repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
