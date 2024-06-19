package entities;

import java.awt.Graphics;
import java.util.Random;

import jeu.Main;
import resources.Chrono;
import resources.Constants;

public class GroupAliens {

/**** VARIABLES ****/	

	public Alien tabAlien[][]=new Alien[5][10];
	private boolean goingRight,pos1;
	private int speed;
	
	private int[] tabAliend = {-1,-1}; 
	
	Random chance = new Random();
	private int number_Alien=Constants.Number_Alien;
	
	
/**** CONSTRUCTEUR ****/
	
	public GroupAliens() {	
		
		this.initTableAliens();
		this.goingRight=true;
		this.pos1=true;
		this.speed=Constants.Alien_speed;
	}

	
/**** METHODES ****/
		
	private void initTableAliens() {
		   for (int column = 0; column < 10; column++) {
		       this.tabAlien[0][column] = new Alien(Constants.xPos_Alien + (Constants.Alien_width + Constants.Alien_c_gap) * column, 
		           Constants.Alien_Alt, "/images/alienHaut1.png", "/images/alienHaut2.png");
		       for (int row = 1; row < 3; row++) {
		           this.tabAlien[row][column] = new Alien(Constants.xPos_Alien + (Constants.Alien_width + Constants.Alien_c_gap) *
		               column, Constants.Alien_Alt + Constants.Alien_gap * row, "/images/alienMilieu1.png", "/images/alienMilieu2.png");
		       }
		       for (int row = 3; row < 5; row++) {    
		           this.tabAlien[row][column] = new Alien(Constants.xPos_Alien + (Constants.Alien_width + Constants.Alien_c_gap) *
		               column, Constants.Alien_Alt + Constants.Alien_gap * row, "/images/alienBas1.png", "/images/alienBas2.png");
		       }    
		   }
		}

		public void dessinAliens(Graphics g) {
			if (Chrono.comp % (100 - 10 * this.speed) == 0) {
				this.deplacementAliens();}
		   for (int column = 0; column < 10; column++) {
		       for (int row = 0; row < 5; row++) {
		    	   if(this.tabAlien[row][column]!=null) {
		    	   this.tabAlien[row][column].chooseImage(pos1);
		           g.drawImage(this.tabAlien[row][column].getImg(), this.tabAlien[row][column].getxPos(), this.tabAlien[row][column].getyPos(),
		               null);
		       }
		       }
		   }
		}
		private boolean touchBordL() {
			   // Method to detect the left edge of the window
			   boolean response = false;
			   for (int column = 0; column < 10; column++) {
			       for (int row = 0; row < 5; row++) {
			           if (this.tabAlien[row][column] != null) {
			               if (this.tabAlien[row][column].getxPos() < Constants.win_Margin) {
			                   response = true;
			                   break;
			               }
			           }
			       }
			   }
			   return response;
			}
		private boolean touchBordR() {
			   // Method to detect the right edge of the window
			   boolean response = false;
			   for (int column = 0; column < 10; column++) {
			       for (int row = 0; row < 5; row++) {
			           if (this.tabAlien[row][column] != null) {
			               if (this.tabAlien[row][column].getxPos()> Constants.win_Width - Constants.Alien_width - Constants.DX_Alien-Constants.win_Margin) {
			                   response = true;
			                   break;
			               }
			           }
			       }
			   }
			   return response;
			}
		public void alienDescend() {
			   // Method to change the direction of alien movement and descend by one step
			   if (this.touchBordR()==true) {            
			       for (int column = 0; column < 10; column++) {
			           for (int row = 0; row < 5; row++) {
			        	   if(this.tabAlien[row][column]!=null) {
			                   this.tabAlien[row][column].setyPos(this.tabAlien[row][column].getyPos() + Constants.DY_Alien);
			        	   }
			           }
			       }
			       this.goingRight = false;
			       if (this.speed < 9) {
			           this.speed++;
			       }
			   } else {
			       if (this.touchBordL()==true) {
			           for (int column = 0; column < 10; column++) {
			               for (int row = 0; row < 5; row++) {
			                   if (this.tabAlien[row][column] != null) {
			                	   if(this.tabAlien[row][column]!=null) {
			                       this.tabAlien[row][column].setyPos(this.tabAlien[row][column].getyPos() + Constants.DY_Alien);
			                   }}
			               }
			           }
			           this.goingRight = true;
			           if (this.speed < 9) {
			               this.speed++;
			           }
			       }
			   }
			}
		public void deplacementAliens() {
			if(this.tabAliend[0] != -1) { 
				elimineAlienMort(tabAliend);
				tabAliend[0] = -1; 
			}
			   if (this.goingRight) { // Moving to the right
			       for (int column = 0; column < 10; column++) {
			           for (int row = 0; row < 5; row++) {
			        	   if(this.tabAlien[row][column]!=null) {
			                   this.tabAlien[row][column].setxPos(this.tabAlien[row][column].getxPos() + Constants.DX_Alien);
			        	   }
			           }
			       }
			   } else { // Moving to the left
			       for (int column = 0; column < 10; column++) {
			           for (int row = 0; row < 5; row++) {
			        	   if(this.tabAlien[row][column]!=null) {
			                   this.tabAlien[row][column].setxPos(this.tabAlien[row][column].getxPos() - Constants.DX_Alien);
			        	   }
			           }
			       }
			   }
			   if(this.pos1==true) {this.pos1=false;}
			   else {this.pos1=true;}
			   this.alienDescend();
			}
		public void BulletHitAlien(BulletV bulletv) {
			for(int colonne=0; colonne<10; colonne++) {
				for(int ligne=0; ligne<5; ligne++) {
					if(this.tabAlien[ligne][colonne] != null) {
						if(bulletv.hitAlien(this.tabAlien[ligne][colonne]) == true) {
							this.tabAlien[ligne][colonne].ani = false; // On tue l'alien
							bulletv.yPos = -1; 
							this.tabAliend[0] = ligne;
							this.tabAliend[1] = colonne; 
							if(ligne == 0) {
								Main.scene.score = Main.scene.score + Constants.VALEUR_ALIEN_HAUT;}
							else if(ligne>0 && ligne<3) {
								Main.scene.score = Main.scene.score + Constants.VALEUR_ALIEN_MILIEU;}
							else {
								Main.scene.score = Main.scene.score + Constants.VALEUR_ALIEN_BAS;}	
							break;
						}
					}					
				}					
			}
		}

		private void elimineAlienMort(int[] tabAlienMort) {
			this.tabAlien[tabAliend[0]][tabAliend[1]] = null;
		}
		
		public int[] choixAlienQuiTire() {
			
			int positionAlien[] = {-1,-1};		
			if(this.number_Alien != 0) { 
				do {int colonne = chance.nextInt(10);  		
					for(int ligne=4;ligne>=0;ligne--) { 
						if(tabAlien[ligne][colonne]!= null) {
							positionAlien[0] = this.tabAlien[ligne][colonne].getxPos();
							positionAlien[1] = this.tabAlien[ligne][colonne].getyPos();
							break;
						}
					}
				} while(positionAlien[0] == -1);
			}	
			return positionAlien;
		}




	
}
