package environment.equipments.offensiveequipment.weapon;

import environment.equipments.offensiveequipment.OffensiveEquipment;

abstract public class Weapon extends OffensiveEquipment {

    public Weapon(String name, String type, int attackLvl) {
        super(name, "Weapon", attackLvl);
    }

    static public Weapon swordOrClub() {
        Weapon newItem=null;
        int i = (int)(Math.random()*2);
        switch(i){
            case 0:
                newItem = new Sword("Couteau à bout rond");
                break;
            case 1:
                newItem = new Club("Cure-dent avec une olive au bout");
        }
        return newItem;
    }
}
