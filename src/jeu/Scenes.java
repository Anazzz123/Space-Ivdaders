package jeu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entities.AlienShoot;
import entities.BulletV;
import entities.GroupAliens;
import entities.Vessel;
import resources.Chrono;
import resources.Constants;
import resources.Keyb;

public class Scenes extends JPanel {
	//variables
	public Vessel vessel=new Vessel();
	public GroupAliens groupAliens= new GroupAliens();
	public BulletV bulletV=new BulletV();
	
	public AlienShoot alienshoot1,alienshoot2,alienshoot3;
	
	
	private Font affScore=new Font("Arial",Font.PLAIN,20);

	private Font texScore=new Font("Arial",Font.PLAIN,80);
	
	public int score=0;
	
	//constructor
	
	public Scenes(){
		super();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyb());
		
		Thread chronoE=new Thread(new Chrono());
		chronoE.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Graphics g2= (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constants.win_Width, Constants.win_Height);
		
		g2.setColor(Color.GREEN);
		g2.fillRect(30, 530, 535, 5);
		
		g.setFont(affScore);
		g.drawString("Score: "+ score, 400,25);
		
		this.vessel.desighnVessel(g2);
		
		this.groupAliens.dessinAliens(g2);
		
		this.bulletV.desighnVesselFire(g2);
		
		this.groupAliens.BulletHitAlien(this.bulletV);
		
		if(Chrono.comp % 500 == 0) {
			alienshoot1 = new AlienShoot(this.groupAliens.choixAlienQuiTire());}
		if(this.alienshoot1 != null) {
			this.alienshoot1.dessinTirAlien(g2);
			//this.alienshoot1.TirAlienDetruitChateau(tabChateaux); // D�tection contact tirAlien1 avec ch�teau
			if(this.alienshoot1.toucheVaisseau(vessel) == true) {this.vessel.setAni(false);}
		}
		if(Chrono.comp % 750 == 0) {
			alienshoot2 = new AlienShoot(this.groupAliens.choixAlienQuiTire());}
		if(this.alienshoot2 != null) {
			this.alienshoot2.dessinTirAlien(g2);
			//this.alienshoot1.TirAlienDetruitChateau(tabChateaux); // D�tection contact tirAlien1 avec ch�teau
			if(this.alienshoot2.toucheVaisseau(vessel) == true) {this.vessel.setAni(false);}
		}
		if(Chrono.comp % 900 == 0) {
			alienshoot3 = new AlienShoot(this.groupAliens.choixAlienQuiTire());}
		if(this.alienshoot3 != null) {
			this.alienshoot3.dessinTirAlien(g2);
			//this.alienshoot1.TirAlienDetruitChateau(tabChateaux); // D�tection contact tirAlien1 avec ch�teau
			if(this.alienshoot3.toucheVaisseau(vessel) == true) {this.vessel.setAni(false);}
		
		}
		if(this.vessel.isAni()==false)
		{
			g.setFont(texScore);
			g.drawString("GAME OVER", 50, 100);
		}
	}
	
}
