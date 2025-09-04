package character;

import environment.enemies.Enemy;
import environment.equipments.defensiveequipment.DefensiveEquipment;
import environment.equipments.defensiveequipment.Shield;
import environment.equipments.offensiveequipment.OffensiveEquipment;
import gamescript.Menu;
import interfaces.IFighter;

abstract public class Character implements IFighter {
    private int id;
    private String type;
    private String name;
    private int health;
    private int basicAttack;
    private OffensiveEquipment attackItem;
    private Shield defenseItem;

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
    public void setId(int id) {
        this.id = id;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    protected void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }
    public void setAttackItem(OffensiveEquipment weapon) {
        this.attackItem = weapon;
    }
    public void setDefenseItem(Shield defenseItem) {
        this.defenseItem = defenseItem;
    }

    // Getters
    public int getId() { return id;}
    public String getType() {
        return type;
    }
    public String getFrenchType() {
        String frenchType = "";
        switch (this.type) {
            case "Warrior":
                frenchType = "Guerrier";
                break;
            case "Wizard":
                frenchType = "Magicien";
                break;
        }
        return frenchType;
    }
    public String getName() { return name; }
    public int getHealth() {
        return health;
    }
    public int getBasicAttack() {
        return basicAttack;
    }
    public OffensiveEquipment getAttackItem() {
        return attackItem;
    }
    public Shield getDefenseItem() {
        return defenseItem;
    }

    //public

    public void getHealed(int healLvl) {
        int newHealth = health + healLvl;
        setHealth(newHealth);
    }

    // toString
    public String toString(){
        return name + " est un " + getFrenchType().toLowerCase() + " avec " + health + " HP et " + basicAttack + " points d'attaque." + (getAttackItem() != null ? "\nVous avez un "+getAttackItem().getName() + " qui améliore vos dégats de "+getAttackItem().getAttackLvl()+" points." : "");
    }


    //Interface methods
    public int attack() {
        return getBasicAttack() + (getAttackItem() != null ? getAttackItem().getAttackLvl() : 0);
    }

    public void receiveDamage(int enemyDamage) {
        int damage = enemyDamage;
        if (getDefenseItem() != null) {
            damage = enemyDamage - getDefenseItem().getDefenseLvl();
            int remainingShieldPoint = getDefenseItem().getDefenseLvl() - enemyDamage;

            if (remainingShieldPoint > 0) {
                getDefenseItem().setDefenseLvl(remainingShieldPoint);
            } else {
                Menu.displayMessage(getDefenseItem().getName()+" est détruit par la force de cette frappe!");
                setDefenseItem(null);
            }
        }

        int remainingHealth = getHealth() - damage;
        if (remainingHealth > 0) {
            setHealth(remainingHealth);
            Menu.displayMessage(getName() + " subit " + enemyDamage + " dégats ce qui lui laisse encore " + getHealth()+" HP!");
        } else {
            Menu.displayMessage(getName()+" est moooooort! Il brûle tel un petit champignon passé à travers la grille du barbeuc' AHAHAHA");
        }
    }

}
