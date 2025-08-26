package character;

import gamescript.Menu;
import equipments.OffensiveEquipment;

public class Character {
    private String[] classesAvailable = {"Warrior", "Wizard"};
    private String type;
    private String name;
    private int health;
    private int basicAttack;
    private OffensiveEquipment weapon;
    private int boardPosition;

    // Constructor
    public Character() {
        Menu.displayMessage("Let's go créer ta future saucisse");

        // Name input
        Menu.displayMessage("Quel sera le nom de ta merguez?");
        String name = Menu.getUserString();

        // Type of character input
        Menu.displayMessage("Quelle classe veux-tu jouer?");
        for (int i = 0; i < this.classesAvailable.length; i++) {
            Menu.displayMessage(i+1 + " - " + classesAvailable[i]);
        }
        int choice = Menu.getUserPosInt(this.classesAvailable.length);

        switch(choice) {
            case 1:
                this.type = "warrior";
                this.health = 10;
                this.basicAttack = 5;
                break;
            case 2:
                this.type = "wizard";
                this.health = 6;
                this.basicAttack = 8;
        }
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
