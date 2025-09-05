package environment.equipments.offensiveequipment;

public abstract class OffensiveEquipment {
    private String name;
    private String type;
    private int attackLvl;

    //Constructor
    public OffensiveEquipment(String name, String type, int attackLvl) {
        this.name = name;
        this.type = type;
        this.attackLvl = attackLvl;
    }
    // Setters
    protected void setType(String type) {
        this.type = type;
    }
    protected void setAttackLvl(int attackLvl) {
        this.attackLvl = attackLvl;
    }
    protected void setName(String name) {
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
    public String getFrenchType() {
        switch (type){
            case "club":
                return "e massue";
            case "fireball":
                return "e boule de feu";
            case "thunder":
                return " éclair";
            case "sword":
                return "e épée";
        }
        return "";
    }
    //toString
    public String toString() {

        return name + ". C'est un"+ getFrenchType()+".";
    }
}
