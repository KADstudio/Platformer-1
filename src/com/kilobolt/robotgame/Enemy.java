package com.kilobolt.robotgame;

import java.util.ArrayList;

import android.graphics.Rect;

public class Enemy {

	private int power, centerX, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	private Robot robot = GameScreen.getRobot();
	private ArrayList<EnemyProjectile> enemyProjectiles = new ArrayList<EnemyProjectile>();
	private boolean readyToFire;
	private int counter = 0;

	public Rect r = new Rect(0, 0, 0, 0);
	public int health = 5;

	private int movementSpeed;

	// Behavioral Methods
	public void update() {
		follow();
		centerX += speedX;
		speedX = bg.getSpeedX() + movementSpeed;
		r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);

		if (Rect.intersects(r, Robot.yellowRed)) {
			checkCollision();
		}

		if (health > 0 && counter >= 25) {
			//shoot();
			counter = 0;
		}
		counter++;

	}

	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3)
				|| Rect.intersects(r, Robot.rect4)) {

		}
	}

	public void shoot() {
		EnemyProjectile p = new EnemyProjectile(centerX - 50, centerY - 10, -7);
		enemyProjectiles.add(p);
	}

	public ArrayList<EnemyProjectile> getEnemyProjectiles() {
		return enemyProjectiles;
	}

	public void setEnemyProjectiles(ArrayList<EnemyProjectile> projectiles) {
		this.enemyProjectiles = projectiles;
	}

	public void follow() {

		if (centerX < -95 || centerX > 810) {
			movementSpeed = 0;
		}

		else if (Math.abs(robot.getCenterX() - centerX) < 5) {
			movementSpeed = 0;
		}

		else {

			if (robot.getCenterX() >= centerX) {
				movementSpeed = 1;
			} else {
				movementSpeed = -1;
			}
		}

	}

	public void die() {

	}

	public void attack() {

	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}