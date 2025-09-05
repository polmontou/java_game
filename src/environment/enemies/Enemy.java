package environment.enemies;

import gamescript.Menu;
import interfaces.IFighter;

abstract public class Enemy implements IFighter {
    private String name;
    private int health;
    private int basicAttack;
    private String type;

    public Enemy(String name, int health, int basicAttack, String type) {
        this.name = name;
        this.health = health;
        this.basicAttack = basicAttack;
        this.type = type;
    }
    //Getter
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getBasicAttack() {
        return basicAttack;
    }
    //Setter
    public void setHealth(int health) {
        this.health = health;
    }

    static public Enemy randomEnemy() {
        Enemy newEnemy=null;
        int i = (int)(Math.random()*3);
        switch(i){
            case 0:
                newEnemy = new Dragon("Weber le Grillant");
                break;
            case 1:
                newEnemy = new Goblin("Grollum le Graissieux");
            case 2:
                newEnemy = new Sorcerer("Charuman le Braisé");
        }
        return newEnemy;
    }

    public String getFrenchType() {
        String frenchType = "";
        switch (this.type){
            case "Sorcerer":
                frenchType = "Sorcier";
                break;
            case "Dragon":
                frenchType = "Dragon";
                break;
            case "Goblin":
                frenchType = "Gobelin";
                break;
        }
        return frenchType;
    }
    //toString
    public String toString() {
         return name + ". C'est un "+ getFrenchType() +" qui a "+health+" HP. \nBon chance petite saucissette!";
    }

    public int attack() {
        return getBasicAttack();
    }

    public void receiveDamage(int playerDamage) {
        int remainingHealth = getHealth()-playerDamage;
        setHealth(remainingHealth);
        Menu.displayMessage(getName() + " subit " + playerDamage + " dégats.");
        if (remainingHealth > 0) {
            Menu.displayMessage("Ce qui lui laisse encore " + getHealth()+" HP!");
        } else {
            Menu.displayMessage(getName()+" est moooooort! Il brûle tel un petit champignon passé à travers la grille du barbeuc' AHAHAHA");
        }
    }
}
