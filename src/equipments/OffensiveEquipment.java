package equipments;

public class OffensiveEquipment {
    private String type;
    private int attackLvl;
    private String name;
    //Constructor
    public OffensiveEquipment(String type, int attackLvl, String name) {
        this.type = type;
        this.attackLvl = attackLvl;
        this.name = name;
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
        return name + " " + type + " " + attackLvl;
    }
}
