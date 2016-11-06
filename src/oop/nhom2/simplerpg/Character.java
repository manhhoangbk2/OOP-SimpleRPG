package oop.nhom2.simplerpg;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Character {
	public static final int STRENGTH = 0;
	public static final int PERCEPTION = 1;
	public static final int ENDURANCE = 2;
	public static final int CHARISMA = 3;
	public static final int INTELLIGENCE = 4;
	public static final int AGILITY = 5;
	public static final int LUCK = 6;
	
	public static final int DIR_UP = 0;
	public static final int DIR_LEFT = 1;
	public static final int DIR_DOWN = 2;
	public static final int DIR_RIGHT = 3;
	
	private Long id;
	private String name;
	private int hp;
	private int mp;
	private int damage;
	private int[] stats;
	private Point pos;
	private ImageIcon imageIcon;
	private int maxHp;
	private int maxMp;
	private String status;

	public Character(Long id, int maxHp, int maxMp, Point pos) {
		this.id = id;
		this.maxHp = hp = maxHp;
		this.maxMp = mp = maxMp;
		this.pos = pos;
	}

	public abstract Point move(int direction);

	public abstract double attack(Character ch);

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
		if(hp<0) this.hp = 0;
		else this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		if(mp<0) this.mp = 0;
		else this.mp = mp;	
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
		for(int i=0;i<stats.length;i++)
			stats[i] = stats[i] % 11;
	}
	
	public int getStat(int field){
		return stats[field];
	}
	public void setStat(int field, int value){
		stats[field] = value % 11;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
		if(hp > this.maxHp) hp = this.maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
		if(mp > this.maxMp) mp = this.maxMp;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	public JLabel getLabel(){
		JLabel label = new JLabel();
		label.setIcon(imageIcon);
		label.setOpaque(false);
		return label;
	}
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
