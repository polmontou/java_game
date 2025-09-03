package environment.enemies;

abstract public class Enemy {
    private String name;
    private int health;
    private int basicAttack;
    private String type;

    public Enemy(String name, int health, int basicAttack, String type) {
        this.name = name;
        this.health = health;
        this.basicAttack = basicAttack;
        this.type = type;
    }

    static public Enemy randomEnemy() {
        Enemy newEnemy=null;
        int i = (int)(Math.random()*3);
        switch(i){
            case 0:
                newEnemy = new Dragon("Weber le Grillant");
                break;
            case 1:
                newEnemy = new Goblin("Grollum le Graissieux");
            case 2:
                newEnemy = new Sorcerer("Charuman le Braisé");
        }
        return newEnemy;
    }

    public String getFrenchType() {
        String frenchType = "";
        switch (this.type){
            case "Sorcerer":
                frenchType = "Sorcier";
                break;
            case "Dragon":
                frenchType = "Dragon";
                break;
            case "Goblin":
                frenchType = "Gobelin";
                break;
        }
        return frenchType;
    }
    //toString
    public String toString() {
         return name + ". C'est un "+ getFrenchType() +" qui a "+health+" HP. \nBon chance petite saucissette!";
    }
}
