package environment.equipments.offensiveequipment.spell;

import environment.equipments.offensiveequipment.OffensiveEquipment;

abstract public class Spell extends OffensiveEquipment {

    public Spell(String name, String type, int attackLvl) {
        super(name, type, attackLvl);
    }

    static public Spell fireballOrThunder() {
        Spell newItem=null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = new Fireball("Boule de graisse brûlée");
                break;
            case 1:
                newItem = new Thunder("Briquet sans gaz");
        }
        return newItem;
    }
}
