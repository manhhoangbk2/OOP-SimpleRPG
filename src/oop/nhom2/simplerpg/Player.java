package oop.nhom2.simplerpg;

import java.awt.Point;

public class Player extends Character {
	private int level;
	private int xp;
	private int xp_limit;
	private int gold;

	Player(Long id, int maxHp, int maxMp, Point pos){
		super(id, maxHp, maxMp, pos);
	}
	
	public int getLevel() {
		return level;
	}

	public int getXp() {
		return xp;
	}
	public void setXP(int xp) {
		if (xp < xp_limit) {
			this.xp = xp;
			return;
		} else {
			this.xp = xp - xp_limit;
			xp_limit = (int)Math.ceil((double)xp_limit*1.1);
			level++;
		}
	}

	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}


	@Override
	public Point move(int direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double attack(Character ch) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
