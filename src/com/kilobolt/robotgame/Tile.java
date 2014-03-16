package com.kilobolt.robotgame;

import android.graphics.Rect;

import com.kilobolt.framework.Image;

public class Tile {

	private int tileX, tileY, speedX;
	public int type;
	public Image tileImage;

	private Robot robot = GameScreen.getRobot();
	private Background bg = GameScreen.getBg1();

	private Rect r;

	public Tile(int x, int y, int typeInt) {
		tileX = x * 40;
		tileY = y * 40;

		type = typeInt;

		r = new Rect();

		if (type == 5) {
			tileImage = Assets.tiledirt;
		} else if (type == 8) {
			tileImage = Assets.tilegrassTop;
		} else if (type == 4) {
			tileImage = Assets.tilegrassLeft;

		} else if (type == 6) {
			tileImage = Assets.tilegrassRight;

		} else if (type == 2) {
			tileImage = Assets.tilegrassBot;
		} else {
			type = 0;
		}
	}

	public void update() {

		speedX = bg.getSpeedX();
		tileX += speedX;
		r.set(tileX, tileY, tileX + 40, tileY + 40);

	}

	public void unUpdate() {
		tileX -= speedX;
		speedX = 0;
		r.set(tileX, tileY, tileX + 40, tileY + 40);
	}

	public boolean checkCollisions() {
		if (Rect.intersects(r, Robot.yellowRed) && type != 0) {
			checkVerticalCollision(Robot.rect, Robot.rect2);
			if (checkSideCollision(Robot.rect3, Robot.rect4)) {
				return true;
			}

		}
		return false;
	}
	
	public static void createGround(){
		Tile t = new Tile(GameScreen.getRobot().getCenterX() - 25, GameScreen.getRobot().getCenterY() - 25, 8);
		GameScreen.getTileArray().add(t);
	}

	public void checkVerticalCollision(Rect rtop, Rect rbot) {
		if (Rect.intersects(rtop, r)) {

		}

		if (Rect.intersects(rbot, r) && type == 8) {
			robot.setJumped(false);
			robot.setSpeedY(0);
			robot.setCenterY(tileY - 25);
		}
	}

	public boolean checkSideCollision(Rect rleft, Rect rright) {
		if (type != 2 && type != 0) {

			// robot.setJumped(false);
			if (Rect.intersects(rleft, r)) {
				robot.setCenterX(tileX + 60);
				
				robot.stopLeft();
				
				// speedX = 0;
				// bg.setSpeedX(0);
				return true;
			}
			if (Rect.intersects(rright, r)) {
				robot.setCenterX(tileX - 20);
				
				robot.stopRight();
				// speedX = 0;
				// bg.setSpeedX(0);
				return true;
			}
		}
		return false;
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public Image getTileImage() {
		return tileImage;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

}