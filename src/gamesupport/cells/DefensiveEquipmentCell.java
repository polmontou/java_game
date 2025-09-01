package gamesupport.cells;

import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.defensiveequipment.Potion;
import environment.equipments.defensiveequipment.Shield;

public class DefensiveEquipmentCell extends Cell{
    private DefensiveEquipment defensiveEquipmentContent;

    public DefensiveEquipmentCell() {
        this.defensiveEquipmentContent = chooseRandomDefensiveEquipment();
    }
    public String toString(){
        return super.toString() + this.defensiveEquipmentContent.toString();
    }

    private DefensiveEquipment chooseRandomDefensiveEquipment(){
        DefensiveEquipment newItem = null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = new Potion("Fond de pot oublié de mayonnaise", 1);
                break;
            case 1:
                newItem = new Shield("Couvercle de Barbeuc'", 3);
        }
        return newItem;
    }
}
