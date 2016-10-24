package oop.nhom2.simplerpg;

import java.util.Vector;

public class AreaMap {
	private String [][] layout;
	private String name;
	private boolean played;
	Vector<NPC> npc;
	Player player = null;
	MapPanel view = null;
	
	public static final int MAP_COLS = 40;
	public static final int MAP_ROWS = 22;
	
	AreaMap(String name, String [][] layout, Vector<NPC> npc){
		this.name = name;
		this.layout = layout.clone();
		this.npc = npc;
		this.played = false;
		this.view = drawView();
	}
	
	AreaMap(String name, String [][] layout, Vector<NPC> npc, Player player){
		this.name = new String(name);
		this.layout = layout.clone();
		this.npc = npc;
		this.player = player;
		this.played = true;
		this.view = drawView();
	}
	
	private MapPanel drawView(){
		MapPanel mp = new MapPanel(layout,MAP_ROWS,MAP_COLS,npc);
		return mp;
	}
	
	public NPC getNPCAt(int index){
		try{
			return this.npc.get(index);
		}catch(ArrayIndexOutOfBoundsException e){
			return null;
		}
	}
	public void addNPC(NPC npc){
		this.npc.add(npc);
	}
	public Vector<NPC> getNpc() {
		return npc;
	}
	public void setNpc(Vector<NPC> npc) {
		this.npc = npc;
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

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isPlayed() {
		return played;
	}
	public void setPlayed(boolean played) {
		this.played = played;
	}
}
