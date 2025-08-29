package character;

import environment.equipments.offensiveequipment.Spell;

public class Wizard extends Character {
    private Spell spell;

    public Wizard(String name) {
        super(name);
        this.type = "Wizard";
        this.health = 6;
        this.basicAttack = 8;
    }
}
