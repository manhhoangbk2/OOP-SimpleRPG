package oop.nhom2.simplerpg;

import java.awt.Point;
import java.util.Vector;

public class NPC extends Character {
	private boolean hostile;
	private Vector<string> dialog;
	
	public NPC(Long id, int maxHp, int maxMp, Point pos){
		super(id,maxHp,maxMp,pos);
		hostile = false;
	}
	public NPC(long id, int maxHp, int maxMp, Point pos, Vector<string> dialog){
		super(id,maxHp,maxMp,pos);
		this.hostile = true;
		this.dialog = dialog;
	}
	
	public void setHostile(boolean hostile){
		this.hostile = hostile;
	}
	
	public boolean getHostile(){
		return this.hostile;
	}
	public void setDialog(Vector<string> dialog){
		this.dialog = dialog.clone();
	}
	
	public Vector<string> getDialog(){
		return dialog;
	}

	@Override
	public int attack() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point move(int direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
