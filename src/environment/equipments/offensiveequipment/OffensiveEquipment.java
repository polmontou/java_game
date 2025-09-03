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

    //toString
    public String toString() {
        String frenchType = "";
        switch (type){
            case "club":
                frenchType = "e massue";
                break;
            case "fireball":
                frenchType = "e boule de feu";
                break;
            case "thunder":
                frenchType = " éclair";
                break;
            case "sword":
                frenchType = "e épée";
                break;
        }
        return name + ". C'est un"+ frenchType +". Ça améliore tes dégâts de freluquet de" + getAttackLvl() + " points.";
    }
}
