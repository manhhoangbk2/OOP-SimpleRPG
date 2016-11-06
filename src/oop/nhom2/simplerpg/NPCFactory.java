package oop.nhom2.simplerpg;

import java.awt.Point;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;

public class NPCFactory {
	private HashMap<String,Vector<NPC>> npc;
	
	public NPCFactory(){
		npc = new HashMap<String,Vector<NPC>>(20);
		
		npc.put("PL", getPrologue());
	}
	
	public Vector<NPC> getNPC(String mapName){
		return npc.get(mapName);
	}
	
	private Vector<NPC> getPrologue(){
		Vector<NPC> list = new Vector<NPC>(15);
		
		list.add(createWarrior(new Point(10,10)));
		
		return list;
	}
	
	private NPC createWarrior(Point pos){
		NPC warrior = new NPC(new Long(1),200,20,pos);
		warrior.setName("Warrior");
		warrior.setDamage(12); warrior.setXp_value(200);
		warrior.setImageIcon(new ImageIcon(this.getClass().getResource("/images/sprites/warrior_spr.png")));
		return warrior;
	}
	
}
