package gamesupport.cells;

import character.Character;
import character.Warrior;
import character.Wizard;
import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.defensiveequipment.potion.BigPotion;
import environment.equipments.defensiveequipment.potion.Potion;
import environment.equipments.defensiveequipment.Shield;
import environment.equipments.defensiveequipment.potion.SmallPotion;
import environment.equipments.offensiveequipment.spell.Fireball;
import environment.equipments.offensiveequipment.spell.Thunder;
import environment.equipments.offensiveequipment.weapon.Club;
import environment.equipments.offensiveequipment.weapon.Sword;

public class DefensiveEquipmentCell extends Cell{
    private DefensiveEquipment defensiveEquipmentContent;

    public DefensiveEquipmentCell() {
        this.defensiveEquipmentContent = chooseRandomDefensiveEquipment();
    }
    public DefensiveEquipmentCell(String type) {
        switch(type) {
            case "smallpotion":
                this.defensiveEquipmentContent = new SmallPotion("Fond de pot de mayo");
                break;
            case "bigpotion":
                this.defensiveEquipmentContent = new BigPotion("Bière tiédie au soleil");
                break;
            case "shield":
                this.defensiveEquipmentContent = new Shield("Couvercle de barbeuc'", 3);
                break;
        }
    }
    public String toString(){
        return super.toString() + this.defensiveEquipmentContent.toString();
    }

    @Override
    public void interact(Character character){
        if(this.defensiveEquipmentContent instanceof Potion){
            int heal = ((Potion) this.defensiveEquipmentContent).getHealLvl();

            character.getHealed(heal);

            if (character instanceof Wizard){
                if (character.getHealth() > 6){
                    character.setHealth(6);
                }
            } else if (character instanceof Warrior){
                if (character.getHealth() > 10){
                    character.setHealth(10);
                }
            }
        } else {
            character.setDefenseItem((Shield)this.defensiveEquipmentContent);
        }
    }

    private DefensiveEquipment chooseRandomDefensiveEquipment(){
        DefensiveEquipment newItem = null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = Potion.smallOrBig();
                break;
            case 1:
                newItem = new Shield("Couvercle de Barbeuc'", 3);
        }
        return newItem;
    }
}
