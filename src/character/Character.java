package character;

import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.offensiveequipment.OffensiveEquipment;

abstract public class Character {
    private String type;
    private String name;
    private int health;
    private int basicAttack;
    private OffensiveEquipment attackItem;
    private DefensiveEquipment defenseItem;

    // Constructor
    Character(String name, String type, int health, int attack) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.basicAttack = attack;
    }
    // Setters
    protected void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    protected void setHealth(int health) {
        this.health = health;
    }
    protected void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }
    protected void setAttackItem(OffensiveEquipment weapon) {
        this.attackItem = weapon;
    }
    protected void setDefenseItem(DefensiveEquipment defenseItem) {
        this.defenseItem = defenseItem;
    }

    // Getters
    protected String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    protected int getHealth() {
        return health;
    }
    protected int getBasicAttack() {
        return basicAttack;
    }
    protected OffensiveEquipment getAttackItem() {
        return attackItem;
    }
    protected DefensiveEquipment getDefenseItem() {
        return defenseItem;
    }

    // toString
    public String toString(){
        return name + " est un " + type.toLowerCase() + " avec " + health + " HP et " + basicAttack + " points d'attaque.";
    }

}
