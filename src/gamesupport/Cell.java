package gamesupport;

import environment.enemies.Enemy;
import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.defensiveequipment.Potion;
import environment.equipments.offensiveequipment.OffensiveEquipment;
import environment.equipments.offensiveequipment.Weapon;

public class Cell {
    private DefensiveEquipment defensiveItemContent;
    private OffensiveEquipment offensiveItemContent;
    private Enemy monster;


    public Cell(int position, String content) {
        switch(content) {
            case "empty" :
                break;
            case "Weapon" :
                this.offensiveItemContent = new Weapon("Lame de Fuego",8);
                break;
            case "Potion" :
                this.defensiveItemContent = new Potion("Potion de Bavouille",8);
                break;
            case "Enemy" :
                this.monster = new Enemy("Tournoyé le Sans-Brassard");
                break;
        }
    }

    //toString
    public String toString () {
        String text;
        if (this.defensiveItemContent != null) {
            text = "Tu trouves : " + this.defensiveItemContent.toString();
        } else if (this.offensiveItemContent != null) {
            text = "Tu trouves : " + this.offensiveItemContent.toString();
        } else if (this.monster != null) {
            text = "Tu tombes face à " + this.monster.toString();
        } else {
            text = "C'est aussi vide qu'entre tes deux oreilles! Tu peux continuer tout droit.";
        }
        return text;
    }
}
