import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements MouseListener, MouseMotionListener {

	Deck stock = new Deck('s');
	Waste[] waste = new Waste[2];
	Deck hand = new Deck('h');
	Tableau[] tableau = new Tableau[7];
	Foundation[] foundation = new Foundation[4];

	Graphics bufferGraphics;
	Image offscreen;

	final int CARD_HEIGHT = 80;
	final int CARD_WIDTH = 56;

	int currentDeck = 0;
	int score = 0;

	public void init() {
		setSize(500, 650);
		setBackground(new Color(7, 89, 45));
		addMouseListener(this);
		addMouseMotionListener(this);

		offscreen = createImage(500, 650);
		bufferGraphics = offscreen.getGraphics();

		stock.setSize(CARD_HEIGHT);
		stock.setCenter(44, 60);
		stock.setColor(Color.ORANGE);

		waste[0] = new Waste();
		waste[1] = new Waste();
		waste[1].setSize(CARD_HEIGHT);
		waste[1].setCenter(114, 60);
		waste[1].setColor(Color.ORANGE);

		hand.setSize(CARD_HEIGHT);
		hand.setCenter(114, 60);
		hand.setColor(Color.ORANGE);

		stock.shuffle();

		for (int i = 0; i < 4; i++) {
			foundation[i] = new Foundation();
			foundation[i].setCenter(223 + (69 * i) + CARD_WIDTH / 2, 20 + CARD_HEIGHT / 2);
			foundation[i].setSize(CARD_HEIGHT);
			foundation[i].setColor(Color.ORANGE);
		}

		for (int i = 0; i < 7; i++) {
			tableau[i] = new Tableau();
			tableau[i].setCenter(44 + (69 * i), 160);
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
			tableau[i].setCurrentPosition(44 + (69 * i), 160 + (tableau[i].getLength() - 1) * 30);
		}
		// for (int i = 0; i < 20; i++) {
		// stock.removeTopCard();
		// }
	}

	public void paint(Graphics g) {

		bufferGraphics.clearRect(0, 0, 500, 650);

		showStatus("Score: " + score);

		bufferGraphics.setColor(new Color(1, 173, 86));
		bufferGraphics.fillRoundRect(16, 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
		bufferGraphics.setColor(new Color(0, 110, 55));
		bufferGraphics.drawRoundRect(16, 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);

		bufferGraphics.setColor(new Color(1, 173, 86));
		bufferGraphics.fillRoundRect(85, 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
		bufferGraphics.setColor(new Color(0, 110, 55));
		bufferGraphics.drawRoundRect(16, 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);

		for (int i = 0; i < 4; i++) {
			bufferGraphics.setColor(new Color(1, 173, 86));
			bufferGraphics.fillRoundRect(223 + (69 * i), 20, CARD_WIDTH, CARD_HEIGHT, 5, 5);
			bufferGraphics.setColor(new Color(0, 110, 55));
			bufferGraphics.drawRoundRect(223 + (69 * i), 20 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			bufferGraphics.setColor(new Color(1, 173, 86));
			bufferGraphics.fillRoundRect(16 + (69 * i), 120, CARD_WIDTH, CARD_HEIGHT, 5, 5);
			bufferGraphics.setColor(new Color(0, 110, 55));
			bufferGraphics.drawRoundRect(16 + (69 * i), 120 - 1, CARD_WIDTH - 1, CARD_HEIGHT, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			tableau[i].draw(bufferGraphics);
		}

		stock.draw(bufferGraphics, 's');
		for (int i = 0; i < 4; i++) {
			foundation[i].draw(bufferGraphics);
		}
		waste[1].draw(bufferGraphics);
		hand.draw(bufferGraphics, 'h');
		g.drawImage(offscreen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void mouseDragged(MouseEvent e) {
		// for (int i = 0; i < 7; i++) {
		// if (tableau[i].isDraggable()) {
		// tableau[i].setCurrentPosition(e.getX(), e.getY());
		// repaint();
		// }
		// }
		if (hand.isDraggable()) {
			hand.setCenter(e.getX(), e.getY());
			repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (hand.getLength() > 0) {
			for (int i = 0; i < 4; i++) {
				if (hand.getLength() > 0) {
					if (foundation[i].isValidMove(e.getX(), e.getY(), hand.getTopCard().getFaceValue(),
							hand.getTopCard().getSuit()) == true) {
						foundation[i].addCard(hand.getTopCard());
						if (currentDeck == 0) {
							waste[1].setCurrentPosition(114 + (waste[1].getLength() - 1) * 30, 60);
						} else if (currentDeck > 0 && currentDeck < 8)
							if (tableau[currentDeck - 1].getLength() > 0
									&& !tableau[currentDeck - 1].getTopCard().getFaceUp()) {
								{
									tableau[currentDeck - 1].flipTopCard();
									score += 5;
								}

							}
						hand.removeTopCard();
						score += 10;
					}
				}
			}

			for (int i = 0; i < 7; i++) {
				if (hand.getLength() == 1 && currentDeck != i + 1) {
					if (tableau[i].isValidMove(e.getX(), e.getY(), hand.getTopCard().getFaceValue(),
							hand.getTopCard().getSuit()) == true) {
						tableau[i].addCard(hand.getTopCard());
						if (currentDeck == 0) {
							waste[1].setCurrentPosition(114 + (waste[1].getLength() - 1) * 30, 60);
							score += 5;
						} else {
							if (currentDeck < 8) {
								if (tableau[currentDeck - 1].getLength() > 0
										&& !tableau[currentDeck - 1].getTopCard().getFaceUp()) {
									tableau[currentDeck - 1].flipTopCard();
									score += 5;
								}
							}

						}
						hand.removeTopCard();
						if (currentDeck > 8) {
							score -= 15;
						}
					}
				} else if (hand.getLength() > 1 && currentDeck != i + 1) {
					if (tableau[i].isValidMove(e.getX(), e.getY(), hand.getBottomCard().getFaceValue(),
							hand.getBottomCard().getSuit()) == true) {
						int k = hand.getLength();
						for (int j = 0; j < k; j++) {
							tableau[i].addCard(hand.getBottomCard());
							hand.removeBottomCard();
						}
						if (tableau[currentDeck - 1].getLength() > 0
								&& !tableau[currentDeck - 1].getTopCard().getFaceUp()) {
							tableau[currentDeck - 1].flipTopCard();
						}
					}
				}
				tableau[i].setCurrentPosition(44 + (69 * i), 160 + (tableau[i].getLength() - 1) * 30);
			}
		}

		if (hand.getLength() > 0 && currentDeck == 0) {
			waste[1].addCard(hand.getTopCard());
			hand.removeTopCard();
			hand.setDraggable(false);
		}

		for (int i = 0; i < 4; i++) {
			if (hand.getLength() == 1 && currentDeck == i + 8) {
				foundation[i].addCard(hand.getTopCard());
				hand.removeTopCard();
				hand.setDraggable(false);
			}
		}

		for (int i = 0; i < 7; i++) {
			if (hand.getLength() == 1 && currentDeck == i + 1) {
				tableau[i].addCard(hand.getTopCard());
				hand.removeTopCard();
				hand.setDraggable(false);
				tableau[i].setCurrentPosition(44 + (69 * i), 160 + (tableau[i].getLength() - 1) * 30);
			}
		}

		for (int i = 0; i < 7; i++) {
			if (hand.getLength() > 1 && currentDeck == i + 1) {
				int k = hand.getLength();
				for (int j = 0; j < k; j++) {
					tableau[i].addCard(hand.getBottomCard());
					hand.removeBottomCard();
					tableau[i].setCurrentPosition(44 + (69 * i), 160 + (tableau[i].getLength() - 1) * 30);
				}
				hand.setDraggable(false);
			}
		}

		if (checkWin()) {
			System.out.println("YOU WON!");
		}

		repaint();
	}

	public void mousePressed(MouseEvent e) {

		for (int i = 0; i < 4; i++) {
			if (foundation[i].isPointInside(e.getX(), e.getY()) == true && foundation[i].getLength() > 0) {
				currentDeck = i + 8;
				hand.addCard(foundation[i].getTopCard());
				foundation[i].removeTopCard();
				if (foundation[i].getLength() > 0) {
					foundation[i].setCurrentValue(foundation[i].getTopCard().getFaceValue());
				} else {
					foundation[i].setCurrentValue(0);
				}

				hand.setDraggable(true);
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < tableau[i].getMaxDrag(); j++) {
				if (tableau[i].isPointInside(e.getX(), e.getY(), j + 1)) {
					for (int k = 0; k <= j + 1; k++) {
						currentDeck = i + 1;
						hand.addCard(tableau[i].getTopCard());
						tableau[i].removeTopCard();
						hand.setDraggable(true);
					}
					hand.reverse();
				}
			}
		}

		if (waste[1].isPointInside(e.getX(), e.getY()) == true && waste[1].getLength() > 0) {
			currentDeck = 0;
			hand.addCard(waste[1].getTopCard());
			waste[1].removeTopCard();
			hand.setDraggable(true);
		}

		for (int i = 0; i < 7; i++) {
			if (tableau[i].isPointInside(e.getX(), e.getY()) && tableau[i].getLength() > 0) {
				currentDeck = i + 1;
				hand.addCard(tableau[i].getTopCard());
				tableau[i].removeTopCard();
				hand.setDraggable(true);
			}
		}
	}

	public boolean checkWin() {
		for (int i = 0; i < 4; i++) {
			if (foundation[i].getLength() != 13) {
				return false;
			}
		}
		return true;
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		if (stock.isPointInside(e.getX(), e.getY()) == true) {
			if (waste[1].getLength() > 0) {
				int j = waste[1].getLength();
				for (int i = 0; i < j; i++) {
					Card card = waste[1].getBottomCard();
					waste[0].addCard(card);
					waste[1].removeBottomCard();
				}
			}
			if (stock.getLength() == 0) {
				int j = waste[0].getLength();
				for (int i = 0; i < j; i++) {
					Card card = waste[0].getTopCard();
					card.setFaceUp(false);
					stock.addCard(card);
					waste[0].removeTopCard();
				}
			} else {
				if (stock.getLength() >= 3) {
					for (int i = 0; i < 3; i++) {
						Card card = stock.getTopCard();
						card.setFaceUp(true);
						waste[1].addCard(card);
						stock.removeTopCard();
					}
				} else {
					int j = stock.getLength();
					for (int i = 0; i < j; i++) {
						Card card = stock.getTopCard();
						card.setFaceUp(true);
						waste[1].addCard(card);
						stock.removeTopCard();
					}
				}
			}
			// TODO Bug with dragging (clicking can make a card teleport to the foundation)
			// System.out.println(114 + (waste[1].getLength() - 1) * 30);
			waste[1].setCurrentPosition(114 + (waste[1].getLength() - 1) * 30, 60);
			repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
