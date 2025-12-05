public class Mage extends Unit {

    public Mage(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Unit target) {
        System.out.println(this.name + " is attacking " + target.name + " with his staff of sorcery.");
        target.takeDamage(this.damage);
    }

}
