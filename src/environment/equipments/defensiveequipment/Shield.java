package environment.equipments.defensiveequipment;

public class Shield extends DefensiveEquipment {
    private int defenseLvl;

    public Shield(String name, int defenseLvl) {
        super(name, "Shield");
        this.defenseLvl = defenseLvl;
    }

    public String toString() {
        return this.getName() + " qui te donne " + defenseLvl + " points de défense.";
    }
}
