package entities;

import javax.swing.ImageIcon;

import resources.Constants;

public class Alien extends Entity{
	public Alien(int xPos,int yPos, String strimg1,String strimg2)
	{
		super.xPos=xPos;
		super.yPos=yPos;
		super.width=Constants.Alien_width;
		super.height=Constants.Alien_height;
		super.dx=0;
		super.dy=0;
		super.ani=true;
		super.strimg1=strimg1;
		super.strimg2=strimg2;
		super .strimg3="/images/alienMeurt.png";
		
		super.ico=new ImageIcon(getClass().getResource(super.strimg1));
		super.img=this.ico.getImage();
		
	}
		public void chooseImage(boolean pos1) {
			 if(this.ani==true) {
			 if(pos1 == true) {super.ico = new ImageIcon(getClass().getResource(strimg1));} 
			  else {super.ico = new ImageIcon(getClass().getResource(strimg2));}		
		}
			 else {super.ico = new ImageIcon(getClass().getResource(strimg3));}
			 super.img=this.ico.getImage();
	
		}
}
