package oop.nhom2.simplerpg;

public class CombatHandler {
	public static final boolean VICTORY = true;
	public static final boolean DEFEAT = false;
	
	private Player p1;
    private NPC p2;
    private int turn = 0;
    private boolean result;

    public CombatHandler(NPC p2, Player p1) {
        this.p2 = p2;
        this.p1 = p1;
    }

    public Character getP1() {
        return p1;
    }

    public Character getP2() {
        return p2;
    }

    public void p1Turn() {
        
    }

    public void p2Turn() {
        
    }

    public boolean combat() {
        while(!combatEnd()){
        	if(turn % 2 == 0) p1Turn();
        	else p2Turn();
        	turn++;
        }
        endCombat();
        
        return result;
    }

    public boolean combatEnd(){
    	if(p1.getHp()==0 || p2.getHp()==0 )
    		return true;
    	return false;
    }
    
    public void endCombat() {
    	//TODO Add ending code
    	if(p1.getHp()==0){
    		
    		result = DEFEAT;
    	}else if(p2.getHp()==0){
    		
    		result = VICTORY;
    	}
    }
}
