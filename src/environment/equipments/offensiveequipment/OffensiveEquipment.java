package environment.equipments.offensiveequipment;

public abstract class OffensiveEquipment {
    protected String type;
    protected int attackLvl;
    protected String name;

    //Constructor
    public OffensiveEquipment(String name, int attackLvl) {
        this.name = name;
        this.attackLvl = attackLvl;
    }
    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setAttackLvl(int attackLvl) {
        this.attackLvl = attackLvl;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getType() {
        return type;
    }
    public int getAttackLvl() {
        return attackLvl;
    }
    public String getName() {
        return name;
    }
    // toString
    public String toString() {
        return name + " qui est " + (type == "Weapon" ? "une arme" : "un sort") + " qui améliore tes dégâts de freluquet de " + attackLvl + " points.";
    }
}
