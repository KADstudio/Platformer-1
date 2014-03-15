package com.kilobolt.robotgame;

import java.util.ArrayList;

import android.graphics.Rect;

public class Robot {

	// Constants are Here
	final int JUMPSPEED = -14;
	final int MOVESPEED = 7;

	private int centerX = 350;
	private int centerY = 415;
	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean facingRight = true;
	private boolean ducked = false;
	private boolean readyToFire = true;
	private int counter;
	private int health = 5;

	private int speedX = 0;
	private int speedY = 0;
	public static Rect rect = new Rect(0, 0, 0, 0);
	public static Rect rect2 = new Rect(0, 0, 0, 0);
	public static Rect rect3 = new Rect(0, 0, 0, 0);
	public static Rect rect4 = new Rect(0, 0, 0, 0);
	public static Rect yellowRed = new Rect(0, 0, 0, 0);

	public static Rect footleft = new Rect(0, 0, 0, 0);
	public static Rect footright = new Rect(0, 0, 0, 0);

	private Background bg1 = GameScreen.getBg1();
	private Background bg2 = GameScreen.getBg2();

	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public void update() {
		// Moves Character or Scrolls Background accordingly.
		counter++;
		if (counter >= 8) {
			readyToFire = true;
		}
		if (speedX == 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);

		}

		else {
			bg1.setSpeedX(-speedX);
			bg2.setSpeedX(-speedX);
		}

		// Updates Y Position
		centerY += speedY;

		// Handles Jumping

		speedY += 1;

		if (speedY > 3) {
			jumped = true;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}

		rect.set(centerX - 20, centerY - 25, centerX + 20, centerY);
		rect2.set(rect.left, centerY, rect.right, centerY + 25);
		rect3.set(centerX - 25, centerY - 20, centerX, centerY);
		rect4.set(centerX, centerY - 20, centerX + 25, centerY);
		yellowRed.set(centerX - 110, centerY - 110, centerX + 70, centerY + 70);

	}

	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

	}

	public void jump() {
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}

	}

	public void shoot() {
		if (readyToFire && counter >= 8) {
			if (facingRight) {
				Projectile p = new Projectile(centerX + 25, centerY - 20, 10);
				projectiles.add(p);
			} else {
				Projectile p = new Projectile(centerX - 25, centerY - 20, -10);
				projectiles.add(p);
			}
			counter = 0;
		}
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
