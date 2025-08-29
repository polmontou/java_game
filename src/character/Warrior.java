package character;

import environment.equipments.offensiveequipment.Weapon;

public class Warrior extends Character {
    protected Weapon weapon;

    public Warrior(String name) {
        super(name);
        this.type = "Warrior";
        this.health = 10;
        this.basicAttack = 5;
    }
}
