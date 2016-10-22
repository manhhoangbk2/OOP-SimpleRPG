package oop.nhom2.simplerpg;

import java.util.Vector;

public class AreaMap {
	private int rows = 22, cols = 40;
	private String [][] layout;
	private String name;
	Vector<NPC> npc;
	Player player = null;
	MapPanel view = null;
	
	AreaMap(String name, String [][] layout, Vector<NPC> npc){
		this.name = name;
		this.layout = layout.clone();
		this.rows = layout.length;
		this.cols = layout[0].length;
		this.npc = new Vector<NPC>(npc);
		this.view = drawView();
	}
	
	AreaMap(String name, String [][] layout, Vector<NPC> npc, Player player){
		this.name = new String(name);
		this.layout = layout.clone();
		this.rows = layout.length;
		this.cols = layout[0].length;
		this.npc = new Vector<NPC>(npc);
		this.player = player;
		this.view = drawView();
	}
	
	private MapPanel drawView(){
		return new MapPanel(layout,rows,cols,npc);
	}
	
	public NPC getNPC(int index){
		NPC npc = null;
		if(index<this.npc.size())
			npc = this.npc.get(index);
		return npc;
	}
	public void addNPC(NPC npc){
		this.npc.add(npc);
	}
	
	public String [][] getLayout(){
		return layout;
	}
	
	public MapPanel getView(){
		return view;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
