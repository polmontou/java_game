package environment.equipments.defensiveequipment;

abstract public class DefensiveEquipment {
    protected String type;
    protected String name;

    //Constructor
    public DefensiveEquipment(String name) {
        this.name = name;

    }
    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

}
