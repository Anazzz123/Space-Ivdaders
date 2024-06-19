package entities;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import resources.Chrono;
import resources.Constants;

public class AlienShoot extends Entity {
	

	Random chance = new Random();


/**** CONSTRUCTeR ****/	
	
	public AlienShoot(int [] tabPositionAlien) {
		
		super.xPos = tabPositionAlien[0] + Constants.Alien_width /2 - 1;
		super.yPos = tabPositionAlien[1] + Constants.Alien_height;
		super.width = Constants.Alien_shoot_width;
		super.height = Constants.Alien_shoot_height;
		super.dx = 0;
		super.dy = Constants.Alien_shoot;
		
		super.strimg1 = "/images/tirAlien1.png";
		super.strimg2 = "/images/tirAlien2.png";
		super.strimg3 = "";
		if(chance.nextInt(2) == 0) {
			super.ico = new ImageIcon(getClass().getResource(super.strimg1));}
		else {super.ico = new ImageIcon(getClass().getResource(super.strimg2));}
		super.img = this.ico.getImage();
	}
	
	
/**** METHODES ****/
	
	public int deplacementAlienShoot() {
		if(Chrono.comp % 4 == 0) {
			if(this.yPos < 600) {this.yPos = this.yPos + Constants.Alien_shoot;}			
		}
		return yPos;
	}	
	
	public void dessinTirAlien(Graphics g) {
		g.drawImage(this.img, this.xPos, this.deplacementAlienShoot(), null);
	}		
	
	
	public boolean toucheVaisseau(Vessel vessel) {
		
		if(this.yPos < vessel.getyPos() + vessel.getHeight() && this.yPos + this.height > vessel.getyPos() 
			&& this.xPos + this.width > vessel.getxPos() && this.xPos < vessel.getxPos() + vessel.getWidth()){
			    this.yPos = 700;
				return true;
			} 
		else{return false;}
	}

}
