package oop.nhom2.simplerpg;

import java.awt.Point;

public class NPC extends Character {
	private boolean hostile;
	private String[] dialog;
	
	NPC(Long id, int maxHp, int maxMp, Point pos){
		super(id,maxHp,maxMp,pos);
		hostile = false;
	}
	
	public void setHostile(boolean hostile){
		this.hostile = hostile;
	}
	
	public boolean getHostile(){
		return this.hostile;
	}
	public void setDialog(String[] dialog){
		this.dialog = dialog.clone();
	}
	
	public String[] getDialog(){
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
