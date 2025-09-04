package environment.enemies;
import character.Character;
import gamescript.Menu;

public class Dragon extends Enemy{

    public Dragon(String name) {
        super(name, 15, 4, "Dragon");
    }

    @Override
    public int attack() {
        Menu.displayMessage("Coup de queue de merguez !");
        return super.attack();
    }
}
