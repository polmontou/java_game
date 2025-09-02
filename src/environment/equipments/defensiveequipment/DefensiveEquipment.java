package environment.equipments.defensiveequipment;

abstract public class DefensiveEquipment {
    private String type;
    private String name;

    //Constructor
    public DefensiveEquipment(String name, String type) {
        this.name = name;
        this.type = type;
    }
    // Setters
    protected void setType(String type) {
        this.type = type;
    }
    protected void setName(String name) {
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
