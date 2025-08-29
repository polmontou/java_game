package environment.equipments.offensiveequipment;

public class Weapon extends OffensiveEquipment {
    final String characterAllowed = "Warrior";

    public Weapon(String name, int attackLvl) {
        super(name, attackLvl);
        this.type = "Weapon";
    }
}
