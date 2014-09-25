import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Immages{
	JLabel image2 = showImage("P2.jpg");
	JLabel image1 = showImage("P1.jpg");
	JLabel image2M = showImage("P2 Mordern.jpg");
	JLabel image1M = showImage("P1 Mordern.jpg");
	JLabel immageBullet1 = showImage("Arrow .png");
	JLabel immageBullet2 = showImage("Arrow 1.png");
	JLabel QR = showImage("QR EASTER EGG.png");

protected JLabel showImage(String fileName) {
	JFrame frame = new JFrame();
	URL imageURL = getClass().getResource(fileName);
	Icon icon = new ImageIcon(imageURL);
	JLabel image = new JLabel(icon);
	return image;
}	
}
