package gamescript;

import character.Character;
import environment.enemies.Enemy;
import exceptions.DeadCharacter;
import gamesupport.Dice;
import interfaces.IFighter;

public class Fight {

    private Dice dice6;
    private Dice dice20;
    private Character character;
    private Enemy enemy;
    private Menu menu;
    private Game game;

    public Fight(Character character, Enemy enemy, Game game) throws DeadCharacter {
        this.dice6 = new Dice(6);
        this.dice20 = new Dice(20);
        this.character = character;
        this.enemy = enemy;
        this.menu = new Menu();
        this.game = game;
        displayFightMenu(this.game);
    }

    private void displayFightMenu(Game Game) throws DeadCharacter {
        int fightChoices = 2;
        boolean fight = true;

        Menu.displayMessage("Honneur au plus faible!");

        while (fight) {
            Menu.displayMessage("\nQue fais-tu?"+
                    "\n1 - Se défendre faiblement" +
                    "\n2 - Fuir");
            int choice = menu.getUserPosInt(fightChoices);
            fight = parseUserChoiceFightMenu(choice, game);
        }
    }

    public boolean parseUserChoiceFightMenu(int choicesAvailable, Game game) throws DeadCharacter {
        switch (choicesAvailable) {
            case 1 :
                Menu.displayMessage("Donne tout ce que t'as! Je suis pas sûr que ça suffise");
                return battle();
            case 2 :
                return flee(game);
        }
        return true;
    }

    private boolean flee(Game game) {
        int roll6 = dice6.roll();
        game.setPlayerPosition(game.getPlayerPosition() - roll6);
        if (game.getPlayerPosition() < 0) {
            game.setPlayerPosition(0);
        }
        Menu.displayMessage("Petit couard, pour la peine tu retournes en case "+game.getPlayerPosition());
        return false;
    }

    private boolean battle() throws DeadCharacter {
        boolean enemyAlive = true;
        boolean imAlive = true;

        enemyAlive = fightTurn(character, enemy);
        if (!enemyAlive) {
            enemy.setHealth(20);
            Menu.displayMessage("Pas si coriace que ça le "+enemy.getFrenchType()+"!");
            return false;
        }
        Menu.displayMessage("\nAu tour de "+enemy.getName()+".");
        imAlive = fightTurn(enemy, character);
        if (!imAlive) {
            Menu.displayMessage("T'étais pas à la hauteur petit cornichon!");
            return false;
        }
        return true;
    }

    private boolean fightTurn(IFighter attack, IFighter defense) throws DeadCharacter {
        int roll20 = dice20.roll();
        int myAttack = attack.attack();

        Menu.displayMessage((attack instanceof Character ? "Tu lances" : attack.getName() + " lance") +" un d20 et ça donne");
        if  (roll20 == 1) {
            Menu.displayMessage("1 => Echec critique HIHIHIHI");
            myAttack = 0;
        } else if (roll20 == 20) {
            Menu.displayMessage("20 => PIOUPIOU la supriiiise, le coup critique! +2 aux dégâts!");
            myAttack += 2;
        } else {
            Menu.displayMessage(roll20+" => Ni CC, ni EC, on s'ennuie un peu ici");
        }

        defense.receiveDamage(myAttack);

        if (defense.getHealth() <= 0) {
            return false;
        }
        return true;
    }


}
