package resources;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import jeu.Main;

public class Keyb implements KeyListener{
	
	public void keyPressed(KeyEvent e)
	{
		if(Main.scene.vessel.isAni()==true)
		{
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			Main.scene.vessel.setDx(Constants.DX_vessel);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			Main.scene.vessel.setDx(-Constants.DX_vessel);
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(Main.scene.bulletV.isVesselFire() == false) {	
				Main.scene.bulletV.setyPos(Constants.YPos_vessel - Constants.Vessel_height);
				Main.scene.bulletV.setxPos(Main.scene.vessel.getxPos() + Constants.Vessel_width/2 - 1);	
				Main.scene.bulletV.setVesselFire(true);
			}
	    }
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		Main.scene.vessel.setDx(0);
	}
	public void keyTyped(KeyEvent ar)
	{
		
	}

}
