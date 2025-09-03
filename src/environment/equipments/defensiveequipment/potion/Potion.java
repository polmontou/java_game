package environment.equipments.defensiveequipment.potion;

import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.defensiveequipment.Shield;

abstract public class Potion extends DefensiveEquipment {
    private int healLvl;

    public Potion(String name, int healLvl) {
        super(name, "Potion");
        this.healLvl = healLvl;
    }
    static public Potion smallOrBig() {
        Potion newItem=null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = new SmallPotion("Fond de pot oublié de mayonnaise");
                break;
            case 1:
                newItem = new BigPotion("Jus de fond d'assiette");
        }
        return newItem;
    }

    //getter
    public int getHealLvl() {
        return healLvl;
    }
    //toString
    public String toString() {
        return this.getName() + " qui te redore la pillule de " + healLvl + " HP.";
    }
}
