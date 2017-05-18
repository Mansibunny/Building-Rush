package com.mc.game;

public class truck {
	private int x, y, speedOffset, speed, direction, destX, destY;
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	
	public truck() {
		x = 0;
		y = 0;
		speedOffset = 0;
		speed = 1 + speedOffset;
		direction = 0;
		destX = 0;
		destY = 0;
	}
	
	public void setXY(int newx, int newy) {
		x = newx;
		y = newy;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setOffset(int newOffset) {
		speedOffset = newOffset;
	}
	
	public int getOffset() {
		return speedOffset;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setDirection(int dir) {
		direction = dir;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDestination(int x, int y) {
		destX = x;
		destY = y;
	}
	
	public int getDestX() {
		return destX;
	}
	
	public int getDestY() {
		return destY;
	}
	
}
