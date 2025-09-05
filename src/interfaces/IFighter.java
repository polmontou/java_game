package interfaces;

import exceptions.DeadCharacter;

public interface IFighter {
    int attack();
    void receiveDamage(int dmg) throws DeadCharacter;
    int getHealth();
    String getName();
}
