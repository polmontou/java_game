package environment.equipments.defensiveequipment;

public class Potion extends DefensiveEquipment {
    private int healLvl;

    public Potion(String name, int healLvl) {
        super(name);
        this.type = "Potion";
        this.healLvl = healLvl;
    }

    //toString
    public String toString () {
        return name + " qui te redore la pillule de " + healLvl + " HP.";
    }
}
