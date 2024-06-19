package entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import resources.Constants;

public class BulletV extends Entity{
	private boolean VesselFire=false;
	
	
		

	public BulletV() {
		
		// Initialisation des variables de la super classe
		super.xPos = 0;
		super.yPos = Constants.YPos_vessel - Constants.Vessel_height;
		super.width = Constants.Vessel_width;
		super.height = Constants.Vessel_height;
		super.dx = 0;
		super.dy = Constants.Vessel_shoot;
		// Adresse des images du vaisseau
		super.strimg1 = "/images/tirVaisseau.png";
		super.strimg2 = "";
		super.strimg3 = "";
		super.ico = new ImageIcon(getClass().getResource(super.strimg1));
		super.img = this.ico.getImage();
	}
		
	
	
		public boolean isVesselFire() {
			return VesselFire;
		}


		public void setVesselFire(boolean vesselFire) {
			VesselFire = vesselFire;
		}
		
		public int deplacementVesselFire() {
			if(this.VesselFire == true) {
				if(this.yPos > 0) {this.yPos = this.yPos - Constants.Vessel_shoot;}
				else {this.VesselFire = false;}
			}		
			return yPos;
		}
		public void desighnVesselFire(Graphics g) {
			if(this.VesselFire == true) {
				g.drawImage(this.img, this.xPos, this.deplacementVesselFire(), null);}	
		}
		
		public boolean hitAlien(Alien alien) {
			if(this.yPos < alien.getyPos() + alien.getHeight() 
				&& this.yPos + this.height > alien.getyPos() 
				&& this.xPos + this.width > alien.getxPos() 
				&& this.xPos < alien.getxPos() + alien.getWidth()){
					return true;
				} 
			else{return false;}
		}
}
