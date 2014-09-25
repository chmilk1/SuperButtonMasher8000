import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class MassherMain implements KeyListener {

	JFrame MasherBoard = new JFrame(
			"537570657220427574746F6E204D61736865722038303030");
	JFrame Hit = new JFrame("Super Button Massher 8000");
	int song;
	JPanel masherPanel = new JPanel();
	JPanel scorePanel = new JPanel();
	Immages image = new Immages();
	int Hex = 0;
	int Old = 0;
	int p1 = 30;
	int p2 = 30;
	String hex;
	String hex1;
	JLabel player1Score = new JLabel();
	JLabel player2Score = new JLabel();
	Random rand = new Random();
	JLabel image2 = image.image2;
	JLabel image1 = image.image1;
	JLabel image2M = image.image2M;
	JLabel image1M = image.image1M;
	JLabel immageBullet1 = image.immageBullet1;
	JLabel immageBullet2 = image.immageBullet2;
	JLabel QR = image.QR;
	Sounds sound = new Sounds();

	public static void main(String[] args) {
		MassherMain main = new MassherMain();
		main.Run();
	}

	private void Run() {

		playSound(sound.song1);
		song = 1;
		Old = JOptionPane.showOptionDialog(null, "Mordern or Medieval?",
				"63686F7365", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Modern",
						"Medieval" }, // this is the array
				"default");
		Hex = JOptionPane.showOptionDialog(null, "Hexadecmal or Decmal",
				"63686F7365", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Decmal",
						"Hex" }, // this is the array
				"default");
		if (Old == 0) {
			playSound(sound.gunCocking);
			// playSound("LMFAO___Champagne_Showers__Arion_Dubstep_Remix__HQ.wav");
		}
		JOptionPane.showMessageDialog(null, "p = red q = blue", "6B657973", 0);
		MasherBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masherPanel.setLayout(new BorderLayout());
		if (Hex == 0) {
			player2Score.setBackground(Color.RED);
			player2Score.setBackground(Color.BLUE);
			player2Score.setText("                     Red Health Points " + p2);
			player1Score.setText("Blue Health Points " + p1 + "                     ");
		} else {
			hex = Integer.toHexString(p2);
			player2Score.setText("Red Health Points " + hex);
			hex1 = Integer.toHexString(p1);
			player1Score.setText("Blue Health Points " + hex1);
		}
		MasherBoard.setSize(1200, 700);
		MasherBoard.addKeyListener(this);
		MasherBoard.add(masherPanel);
		if (Old == 0) {;
			/*
			 * Adding the things to the panel
			 */
			masherPanel.add(image1M, BorderLayout.WEST);
			masherPanel.add(image2M, BorderLayout.EAST);
			masherPanel.add(scorePanel, BorderLayout.SOUTH);
			scorePanel.add(player1Score, BorderLayout.WEST);
			scorePanel.add(player2Score, BorderLayout.EAST);
			masherPanel.add(QR, BorderLayout.CENTER);
		} else if (Old == 1) {
			masherPanel.add(image1, BorderLayout.WEST);
			masherPanel.add(image2, BorderLayout.EAST);
			masherPanel.add(scorePanel, BorderLayout.SOUTH);
			scorePanel.add(player1Score, BorderLayout.WEST);
			scorePanel.add(player2Score, BorderLayout.EAST);
			masherPanel.add(QR, BorderLayout.CENTER);
			
		}
		MasherBoard.pack();
		MasherBoard.setSize(1300, 700);
		MasherBoard.setVisible(true);
		strikeCheck();

	}

	private void strikeCheck() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		masherPanel.remove(immageBullet2);
		masherPanel.remove(immageBullet1);
		MasherBoard.setSize(1200, 700);

		// System.out.println(e);
		if (p2 <= 0) {
			JOptionPane.showMessageDialog(null, "Blue wins with " + p1
					+ " Health Points");
			p2 = 21;
			p1 = 20;
			playSound(sound.kill);
		}
		if (p1 <= 0) {
			JOptionPane.showMessageDialog(null, "Red wins with " + p2
					+ " Health Points");
			p2 = 20;
			p1 = 21;
			playSound(sound.kill);
		}
		if (e.getKeyCode() == 81) {
			System.out.println("blue");
			int strike2 = rand.nextInt(4);
			if (strike2 == 3) {
				p2--;
				if (Hex == 0) {
					player2Score.setText("                     Red Health Points " + p2);
				} else {
					hex = Integer.toHexString(p2);
					player2Score.setText("                     Red Health Points " + hex);
				}
				if (Old == 0) {
					playSound(sound.shot);
					masherPanel.add(immageBullet2, BorderLayout.NORTH);
				} else if (Old == 1) {
					playSound(sound.medHit);
					masherPanel.add(immageBullet2, BorderLayout.NORTH);
				}
				int heal1 = rand.nextInt(66);
				if (heal1 == 5) {
					playSound(sound.drink);
					p1 = p1 + 10;
				}
				// p1++;
				// p1L.setText("" + p1);
				// p1L.repaint();
				// System.out.println(p1 + " p1");
			}
		}
		if (e.getKeyCode() == 80) {
			System.out.println("red");
			int strike = rand.nextInt(4);
			if (strike == 3) {
				p1--;
				if (Hex == 0) {
					player1Score.setText("Blue Health Points " + p1 + "                     " );
				} else {
					hex1 = Integer.toHexString(p1);
					player1Score.setText("Blue Health Points " + hex1 + "                     ");
				}
				if (Old == 0) {
					playSound(sound.shot);
					masherPanel.add(immageBullet1, BorderLayout.SOUTH);
				} else if (Old == 1) {
					playSound(sound.medHit);
					masherPanel.add(immageBullet1, BorderLayout.SOUTH);
				}
				int heal = rand.nextInt(66);
				if (heal == 5) {
					playSound(sound.drink);
					p2 = p2 + 10;
				}
			}
		}
	}

	// p2++;
	// p2L.setText("" + p2);
	// p2L.repaint();
	// System.out.println(p2 + " p2");

	// MasherBoard.repaint();

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	protected JLabel showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		return image;
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet
				.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
