package environment.enemies;

import character.Character;
import gamescript.Menu;

public class Goblin extends Enemy{

    public Goblin(String name) {
        super(name, 6, 1, "Goblin");
    }

    @Override
    public int attack() {
        Menu.displayMessage("Gnihihihi, crachat de gobelin!");
        return super.attack();
    }
}
