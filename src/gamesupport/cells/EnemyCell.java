package gamesupport.cells;

import environment.enemies.Enemy;

public class EnemyCell extends Cell {
    private Enemy enemy;

    public EnemyCell() {
        this.enemy = new Enemy("Tournoyé le Sans-Brassard");
    }
    @Override
    public String toString() {
        return super.toString() + this.enemy.toString();
    }
}
