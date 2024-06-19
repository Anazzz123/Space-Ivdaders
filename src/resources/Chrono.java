package resources;

import jeu.Main;

public class Chrono implements Runnable{
	private final int pause =5;
	public static int comp=0;
	
	
	@Override
	public void run() {
		while(Main.jeu==true)
		{
			comp++;
			Main.scene.repaint();
			try {
				Thread.sleep(pause);
			}
			catch(InterruptedException e)
			{}
		}
	}

}
