package entities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Entity {
	protected int width,height,xPos,yPos,dx,dy;
	protected boolean ani;
	protected String strimg1,strimg2,strimg3;
	protected ImageIcon ico;
	protected Image img;
	
	
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public boolean isAni() {
		return ani;
	}
	public void setAni(boolean ani) {
		this.ani = ani;
	}
	public String getStrimg1() {
		return strimg1;
	}
	public void setStrimg1(String strimg1) {
		this.strimg1 = strimg1;
	}
	public String getStrimg2() {
		return strimg2;
	}
	public void setStrimg2(String strimg2) {
		this.strimg2 = strimg2;
	}
	public String getStrimg3() {
		return strimg3;
	}
	public void setStrimg3(String strimg3) {
		this.strimg3 = strimg3;
	}
	public ImageIcon getIco() {
		return ico;
	}
	public void setIco(ImageIcon ico) {
		this.ico = ico;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
	
	
	
	
	
}
