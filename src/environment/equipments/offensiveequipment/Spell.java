package environment.equipments.offensiveequipment;

public class Spell extends OffensiveEquipment {

    public Spell(String name, int attackLvl) {
        super(name, attackLvl);
        this.type = "Spell";
    }
}
