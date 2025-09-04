package gamescript;

import character.Character;
import environment.enemies.Enemy;
import gamesupport.Dice;

public class Fight {

    private Dice dice6;
    private Dice dice20;
    private Character character;
    private Enemy enemy;

    public Fight(Character character, Enemy enemy){
        this.dice6 = new Dice(6);
        this.dice20 = new Dice(20);
        this.character = character;
        this.enemy = enemy;
        playFightTurn();
    }

    private void playFightTurn() {
        boolean charAlive = true;
        boolean enemyAlive = true;


    }
}
