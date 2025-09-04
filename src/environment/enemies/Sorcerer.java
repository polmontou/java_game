package environment.enemies;

import character.Character;
import gamescript.Menu;

public class Sorcerer extends Enemy{

    public Sorcerer(String name) {
        super(name, 9, 2, "Sorcerer");
    }

    @Override
    public int attack() {
        Menu.displayMessage("Invocation de la braise grasse!");
        return super.attack();
    }

}
