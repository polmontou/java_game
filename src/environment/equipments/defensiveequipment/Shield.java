package environment.equipments.defensiveequipment;

public class Shield extends DefensiveEquipment {
    private int defenseLvl;

    public Shield(String name, int defenseLvl) {
        super(name, "Shield");
        this.defenseLvl = defenseLvl;
    }
    public void setDefenseLvl(int defenseLvl) {
        this.defenseLvl = defenseLvl;
    }
    public int getDefenseLvl() {
        return defenseLvl;
    }

    public String toString() {
        return this.getName() + " qui te donne " + defenseLvl + " points de défense.";
    }
}
