package environment.equipments.offensiveequipment;

public class Spell extends OffensiveEquipment {
    final String characterAllowed = "Wizard";
    public Spell(String name, int attackLvl) {
        super(name, attackLvl);
        this.type = "Spell";
    }
}
