package gamesupport.cells;

import environment.equipments.offensiveequipment.OffensiveEquipment;
import environment.equipments.offensiveequipment.Spell;
import environment.equipments.offensiveequipment.Weapon;

public class OffensiveEquipmentCell extends Cell {
    private OffensiveEquipment offensiveEquipmentContent;

    public OffensiveEquipmentCell() {
        this.offensiveEquipmentContent = chooseRandomOffensiveEquipment();
    }

    public String toString() {
        return super.toString() + this.offensiveEquipmentContent.toString();
    }

    private OffensiveEquipment chooseRandomOffensiveEquipment(){
        OffensiveEquipment newItem = null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = new Weapon("Pic à brochette", 5);
                break;
            case 1:
                newItem = new Spell("Boule de graisse brûlée", 5);
        }
        return newItem;
    }
}
