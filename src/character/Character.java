package character;

import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.offensiveequipment.OffensiveEquipment;

abstract public class Character {
    protected String type;
    protected String name;
    protected int health;
    protected int basicAttack;
    protected OffensiveEquipment attackItem;
    protected DefensiveEquipment defenseItem;

    // Constructor
    Character(String name) {
        this.name = name;
    }
    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }
    public void setAttackItem(OffensiveEquipment weapon) {
        this.attackItem = weapon;
    }
    public void setDefenseItem(DefensiveEquipment defenseItem) {
        this.defenseItem = defenseItem;
    }

    // Getters
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getBasicAttack() {
        return basicAttack;
    }
    public OffensiveEquipment getAttackItem() {
        return attackItem;
    }
    public DefensiveEquipment getDefenseItem() {
        return defenseItem;
    }

    // toString
    public String toString(){
        return name + " est un " + type.toLowerCase() + " avec " + health + " HP et " + basicAttack + " points d'attaque.";
    }

}
