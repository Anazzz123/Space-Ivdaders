package entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import jeu.Main;
import resources.Chrono;
import resources.Constants;

public class Vessel extends Entity{
	
	private int computer=0;
	
	public Vessel()
	{
		super.xPos=Constants.Xpos_init_vessel;
		super.yPos=Constants.YPos_vessel;
		super.width=Constants.Vessel_width;
		super.height=Constants.Vessel_height;
		super.dx=0;
		super.dy=0;
		
		super.strimg1="/images/vaisseau.png";
		super.strimg2="/images/vaisseauDetruit1.png";
		super.strimg3="/images/vaisseauDetruit2.png";
		
		super.ico=new ImageIcon(getClass().getResource(super.strimg1));
		super.img=this.ico.getImage();
		super.ani=true;
		
	}
		public int deplacementVessel()
		{
			if(this.dx<0) {
				if(this.xPos>Constants.limitl_vessel){
					this.xPos=this.xPos+this.dx;
				}
			}
			else if(dx>0) {
				if(this.xPos+this.dx<Constants.limitr_vessel){
					this.xPos=this.xPos+this.dx;
					}
				}
			return this.xPos;
		
		}
		public void desighnVessel(Graphics g) {
			if(this.ani==false) {this.destructionVessel();}
			g.drawImage(this.img,this.deplacementVessel(),this.yPos,null);
		}
		public void destructionVessel() {
			if(computer < 300) {
				if(Chrono.comp % 2 == 0) {super.ico = new ImageIcon(getClass().getResource(super.strimg2));}
				else {super.ico = new ImageIcon(getClass().getResource(super.strimg3));}
				computer++;
			}else {Main.jeu = false;}		
			super.img = this.ico.getImage();
		}
}
