package gamesupport.cells;

import character.Character;
import environment.enemies.Dragon;
import environment.enemies.Enemy;
import environment.enemies.Goblin;
import environment.enemies.Sorcerer;
import gamescript.Fight;
import gamescript.Menu;

public class EnemyCell extends Cell {
    private Enemy enemy;

    public EnemyCell() {
        this.enemy = Enemy.randomEnemy();
    }

    public EnemyCell(String type) {
        switch(type) {
            case "goblin":
                this.enemy = new Goblin("Grollum le Graissieux");
                break;
            case "sorcerer":
                this.enemy = new Sorcerer("Charuman le Braisé");
                break;
            case "dragon":
                this.enemy = new Dragon("Weber le Carbonisant");
        }
    }

    @Override
    public void interact(Character character){
        Menu.displayMessage("COUcOU");
        //Fight fight = new Fight(character, this.enemy);
    }

    @Override
    public String toString() {
        return super.toString() + this.enemy.toString();
    }
}
