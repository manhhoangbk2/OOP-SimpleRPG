package oop.nhom2.simplerpg;

public class CombatHandler {

    NPC character2;
    Player character1;
    int turn = 0;

    public CombatHandler(NPC character2, Player character1) {
        this.character2 = character2;
        this.character1 = character1;
    }

    public CombatHandler() {
    }

    public Character getCharacter1() {
        return character1;
    }

    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(NPC character2) {
        this.character2 = character2;
    }

    public void playerTurn() {
        turn = 1;
    }

    public void NPCTurn() {
        turn = 0;
    }

    public boolean checkVaCham() {
        //ham va cham
        return true;
    }

    public void comBat() {
        while (character1.getHp() > 0 && character2.getHp() > 0) {
            if (checkVaCham() == true) {
                if (turn == 0) {
                    character1.attack();
                    character2.setHp(character2.getHp() - character1.getDamage());
                    playerTurn();
                } else if (turn == 1) {
                    character2.attack();
                    character1.setHp(character1.getHp() - character2.getDamage());
                    NPCTurn();
                }
            }

        }
    }

    public void endPlayerCombat() {
        if (character2.getHp() == 0) {
            character1.setLevel(character1.getLevel() + 1);
            // Ham huy quai vat
            // exp tang
            System.out.println(" you WIN");
        }
    }

    public void endNPCCombat() {
        if (character1.getHp() == 0) {
            System.out.println("Ban thua sap mat rooi");
        }
    }
}
