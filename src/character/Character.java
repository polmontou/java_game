package character;

import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.offensiveequipment.OffensiveEquipment;

abstract public class Character {
    protected String type;
    protected String name;
    protected int health;
    protected int basicAttack;
    protected OffensiveEquipment weapon;
    protected DefensiveEquipment defense;
    protected int boardPosition;

    // Constructor
    Character(String name) {
        this.name = name;
        this.boardPosition = 0;
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
    public void setWeapon(OffensiveEquipment weapon) {
        this.weapon = weapon;
    }
    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
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
    public OffensiveEquipment getWeapon() {
        return weapon;
    }
    public int getBoardPosition() {
        return boardPosition;
    }

    // toString
    public String toString(){
        return name + " est un " + type.toLowerCase() + " avec " + health + " HP et " + basicAttack + " points d'attaque.";
    }

    public void moveCharacter(int throwResult){
        setBoardPosition(this.boardPosition + throwResult);
    }
}
