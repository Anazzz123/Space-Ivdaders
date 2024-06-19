package jeu;
 
import javax.swing.JFrame;

import resources.Constants;
public class Main {
	
	public static Scenes scene;
	public static boolean jeu=true;
	
	public static void main(String[] args)
	{
		JFrame window=new JFrame("Space Invaders");
		window.setSize(Constants.win_Width,Constants.win_Height);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setAutoRequestFocus(true);
		
		scene=new Scenes();
		window.setContentPane(scene);
		
		
		window.setVisible(true);
	}
}
