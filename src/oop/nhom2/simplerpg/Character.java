package oop.nhom2.simplerpg;

import java.awt.Point;

public abstract class Character {
	private Long id;
	private String name;
	private int hp;
	private int mp;
	private int damage;
	private int[] stats;
	
	private static final int MAX_HP=100; //100%
	private static final int MAX_MP=100;//100%
	
	public abstract Point move(int direction);
	
	public abstract void attack();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int[] getStats() {
		return stats;
	}
	public void setStats(int[] stats) {
		this.stats = stats;
	}

	
}
