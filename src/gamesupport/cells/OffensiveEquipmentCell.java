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
import gamescript.Game;
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
    public void interact(Character character, Game game){
        if(compatibilityTest(character)){
            character.setAttackItem(offensiveEquipmentContent);
            Menu.displayMessage("Tu ramasses l'équipement : ça améliore tes dégâts d'attaque de "+offensiveEquipmentContent.getAttackLvl()+" points !");
            Menu.displayMessage("Tu as maintenant "+(character.getBasicAttack()+offensiveEquipmentContent.getAttackLvl())+" points d'attaque!");
        } else {
            Menu.displayMessage("C'est par pour les petits "+character.getFrenchType().toLowerCase()+"s. Laisse ça tranquille, tu vas te faire mal.");
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
