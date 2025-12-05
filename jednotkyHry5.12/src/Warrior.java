public class Warrior extends Unit {

    public Warrior(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Unit target) {
        System.out.println(this.name + " is attacking " + target.name + " with his axe.");
        target.takeDamage(this.damage);
    }

}
