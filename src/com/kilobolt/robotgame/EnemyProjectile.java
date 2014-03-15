package com.kilobolt.robotgame;

import android.graphics.Rect;

public class EnemyProjectile extends Projectile {

	public EnemyProjectile(int startX, int startY, int speed) {
		super(startX,startY,speed);
	}

	@Override
	public void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)) {
			visible = false;

			if (GameScreen.getRobot().getHealth() > 0) {
				GameScreen.getRobot().setHealth(
						GameScreen.getRobot().getHealth() - 1);
			}
		}

	}
}
