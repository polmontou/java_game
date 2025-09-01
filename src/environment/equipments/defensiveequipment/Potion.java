package environment.equipments.defensiveequipment;

public class Potion extends DefensiveEquipment {
    private int healLvl;

    public Potion(String name, int healLvl) {
        super(name, "Potion");
        this.healLvl = healLvl;
    }

    //toString
    public String toString () {
        return this.getName() + " qui te redore la pillule de " + healLvl + " HP.";
    }
}
