package environment.equipments.defensiveequipment;

public class Shield extends DefensiveEquipment {
    private int defenseLvl;

    public Shield(String name, int defenseLvl) {
        super(name);
        this.type = "Shield";
        this.defenseLvl = defenseLvl;
    }
}
