import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Unit warrior = new Warrior("Conan", 50, 10);
        Unit mage = new Mage("Elric", 30, 30);
        Unit archer = new Archer("Legolas", 40, 5);

        ArrayList<Unit> characters = new ArrayList<>();

        characters.add(warrior);
        characters.add(mage);
        characters.add(archer);

        for (Unit unit : characters) {
            unit.attack(archer);
        }
    }

    //100%
}
