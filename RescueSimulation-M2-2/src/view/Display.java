package view;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Display extends Canvas implements Runnable  {
	
	public static final int Width = 800;
	public static final int height = 500;
	public static GraphicsDevice myDevice;
	private Thread thread;
	private boolean running = false;
	

	
	
	public static void main(String [] args) {
		Display game = new Display();
		JFrame frame = new JFrame();
		JButton button = new JButton();
		JPanel panel = new JPanel();
		frame.add(game);
		frame.add(button);
	
		button.setText("building");
		button.setSize(1, 1);
		
		ImageIcon img = new ImageIcon("Resources/universe1.jpg");
		button.setIcon(img);
		
		button.setVisible(true);
		button.setLocation(100, 100);
		//button.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	//	frame.setUndecorated(true);
	//myDevice.setFullScreenWindow(frame);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Bletchely Park");
		frame.setResizable(false);
		frame.setVisible(true);
		//game.start();
	}
	@Override
	public void run() {
		
		while(running) {
			
		}
	}

}
