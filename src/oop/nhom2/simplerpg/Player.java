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
	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}

	void setXP(int xp) {
		if (xp < xp_limit) {
			this.xp = xp;
			return;
		} else {
			this.xp = xp - xp_limit;
			level++;
		}
	}

	@Override
	public Point move(int direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int attack() {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
