package environment.equipments.offensiveequipment;

public class Weapon extends OffensiveEquipment {

    public Weapon(String name, int attackLvl) {
        super(name, attackLvl);
        this.type = "Weapon";
    }
}
