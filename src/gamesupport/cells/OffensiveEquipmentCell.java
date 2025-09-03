package gamesupport.cells;

import character.Character;
import character.Warrior;
import character.Wizard;
import com.google.gson.Gson;
import environment.enemies.Dragon;
import environment.enemies.Goblin;
import environment.enemies.Sorcerer;
import environment.equipments.offensiveequipment.OffensiveEquipment;
import environment.equipments.offensiveequipment.spell.Fireball;
import environment.equipments.offensiveequipment.spell.Spell;
import environment.equipments.offensiveequipment.spell.Thunder;
import environment.equipments.offensiveequipment.weapon.Club;
import environment.equipments.offensiveequipment.weapon.Sword;
import environment.equipments.offensiveequipment.weapon.Weapon;
import gamescript.Menu;

public class OffensiveEquipmentCell extends Cell {
    private OffensiveEquipment offensiveEquipmentContent;

    public OffensiveEquipmentCell() {
        this.offensiveEquipmentContent = chooseRandomOffensiveEquipment();
    }

    public OffensiveEquipmentCell(String type) {
        switch(type) {
            case "club":
                this.offensiveEquipmentContent = new Club("Cure-dent avec une olive au bout");
                break;
            case "sword":
                this.offensiveEquipmentContent = new Sword("Couteau à bout rond");
                break;
            case "thunder":
                this.offensiveEquipmentContent = new Thunder("Briquet sans gaz");
                break;
            case "fireball":
                this.offensiveEquipmentContent = new Fireball("Boule de graisse brûlée");
                break;
        }
    }

    public String toString() {
        return super.toString() + this.offensiveEquipmentContent.toString();
    }

    @Override
    public void interact(Character character){
        if(compatibilityTest(character)){
            character.setAttackItem(offensiveEquipmentContent);
            Menu.displayMessage("Vous ramassez "+offensiveEquipmentContent.getName()+" !");
            Menu.displayMessage("Vous avez maintenant "+(character.getBasicAttack()+offensiveEquipmentContent.getAttackLvl())+" points d'attaque!");
        } else {
            Menu.displayMessage("Laisse ça tranquille, tu vas te faire mal. C'est par pour les petits "+character.getFrenchType()+"s.");
        }
    }

    private boolean compatibilityTest(Character character){
        if(this.offensiveEquipmentContent instanceof Spell && character instanceof Wizard
        || this.offensiveEquipmentContent instanceof Weapon && character instanceof Warrior){
            return true;
        }
        return false;
    }

    private OffensiveEquipment chooseRandomOffensiveEquipment(){
        OffensiveEquipment newItem = null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = Weapon.swordOrClub();
                break;
            case 1:
                newItem = Spell.fireballOrThunder();
        }
        return newItem;
    }
}
