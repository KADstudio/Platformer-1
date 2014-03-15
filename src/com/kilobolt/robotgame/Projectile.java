package com.kilobolt.robotgame;

import android.graphics.Rect;


public class Projectile {

	private int x, y, speedX;
	protected boolean visible;
	
	protected Rect r;
	public Projectile(){};
	public Projectile(int startX, int startY, int speed){
		x = startX;
		y = startY;
		speedX = speed;
		visible = true;
		
		r = new Rect(0, 0, 0, 0);
	}
	
	public void update(){
		x += speedX + GameScreen.getBg1().getSpeedX();
		r.set(x, y, x+10, y+5);
		if (x > 800 || x < 0){
			visible = false;
			r = null;
		}
		if (visible){
			checkCollision();
		}
		
	}

	public void checkCollision() {
	
		
		
		if (Rect.intersects(r, GameScreen.hb2.r)){
			visible = false;

			if (GameScreen.hb2.health > 0) {
				GameScreen.hb2.health -= 1;
			}
			if (GameScreen.hb2.health == 0) {
				GameScreen.hb2.setCenterX(-100);
				

			}

		}
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Rect getR() {
		return r;
	}
	public void setR(Rect r) {
		this.r = r;
	}
	
	
}
