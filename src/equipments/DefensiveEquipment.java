package equipments;

public class DefensiveEquipment {
    private String type;
    private int defenseLvl;
    private String name;
    //Constructor
    public DefensiveEquipment(String type, int defenseLvl, String name) {
        this.type = type;
        this.defenseLvl = defenseLvl;
        this.name = name;
    }
    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setAttackLvl(int defenseLvl) {
        this.defenseLvl = defenseLvl;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getType() {
        return type;
    }
    public int getAttackLvl() {
        return defenseLvl;
    }
    public String getName() {
        return name;
    }
    //toString
    public String toString() {
        return name + " " + type + " " + defenseLvl;
    }
}
