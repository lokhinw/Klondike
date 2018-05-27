import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements MouseListener, MouseMotionListener {

	Deck d1 = new Deck('s');
	Deck d2 = new Deck();
	Deck[] tableau = new Deck[7];

	Graphics g;

	public void init() {
		g = getGraphics();
		d1.shuffle();

		setSize(500, 550);
		setBackground(new Color(7, 89, 45));
		addMouseListener(this);
		addMouseMotionListener(this);
		d1.setSize(80);
		d1.setCenter(44, 60);
		d1.setColor(Color.ORANGE);

		d2.setSize(80);
		d2.setCenter(112, 60);
		d2.setColor(Color.ORANGE);

		for (int i = 0; i < 7; i++) {
			tableau[i] = new Deck();
			for (int j = 0; j < i + 1; j++) {
				Card card = d1.getTopCard();
				if (i == j) {
					card.setFaceUp(true);
				}
				tableau[i].setSize(80);
				tableau[i].setColor(Color.ORANGE);
				tableau[i].addCard(card);
				d1.removeTopCard();
			}
		}

	}

	public void paint(Graphics g) {
		g.setColor(new Color(1, 173, 86));
		g.fillRoundRect(16, 20, 56, 80, 5, 5);
		g.setColor(new Color(0, 110, 55));
		g.drawRoundRect(16, 20 - 1, 56 - 1, 80, 5, 5);

		g.setColor(new Color(1, 173, 86));
		g.fillRoundRect(85, 20, 56, 80, 5, 5);
		g.setColor(new Color(0, 110, 55));
		g.drawRoundRect(85, 20 - 1, 56 - 1, 80, 5, 5);

		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(1, 173, 86));
			g.fillRoundRect(223 + (69 * i), 20, 56, 80, 5, 5);
			g.setColor(new Color(0, 110, 55));
			g.drawRoundRect(223 + (69 * i), 20 - 1, 56 - 1, 80, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			g.setColor(new Color(1, 173, 86));
			g.fillRoundRect(16 + (69 * i), 120, 56, 80, 5, 5);
			g.setColor(new Color(0, 110, 55));
			g.drawRoundRect(16 + (69 * i), 120 - 1, 56 - 1, 80, 5, 5);
		}

		for (int i = 0; i < 7; i++) {
			tableau[i].setCenter(44 + (69 * i), 160);
			tableau[i].draw(g, 't');
		}
		
		d1.draw(g, 's');
		d2.draw(g ,'w');
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		if (d1.isPointInside(e.getX(), e.getY()) == true) {
			if (d1.getDeckLength() == 0) {
				for (int i = 0; i < 24; i++) {
					Card card = d2.getTopCard();
					card.setFaceUp(false);
					d1.addCard(card);
					d2.removeTopCard();
				}
			} else {
				for (int i = 0; i < 3; i++) {
					Card card = d1.getTopCard();
					card.setFaceUp(true);
					d2.addCard(card);
					d1.removeTopCard();
				}
			}
		}
		repaint();
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