package oop.nhom2.simplerpg;

import java.awt.Point;
import java.util.Vector;

public class NPC extends Character {
	private boolean hostile;
	private Vector<String> dialog;
	private int xp_value = 1;
	
	public NPC(Long id, int maxHp, int maxMp, Point pos){
		super(id,maxHp,maxMp,pos);
		hostile = true;
	}
	public NPC(long id, int maxHp, int maxMp, Point pos, Vector<String> dialog){
		super(id,maxHp,maxMp,pos);
		this.hostile = false;
		this.dialog = dialog;
	}
	
	public void setHostile(boolean hostile){
		this.hostile = hostile;
	}
	public boolean getHostile(){
		return this.hostile;
	}
	
	public void setDialog(Vector<String> dialog){
		this.dialog = dialog;
	}
	public Vector<String> getDialog(){
		return dialog;
	}

	public int getXp_value() {
		return xp_value;
	}
	public void setXp_value(int xp_value) {
		this.xp_value = xp_value;
	}
	
	@Override
	public double attack(Character ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point move(int direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
