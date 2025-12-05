public class Archer extends Unit {

    public Archer(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Unit target) {
        System.out.println(this.name + " is attacking " + target.name + " with his bow and arrows.");
        target.takeDamage(this.damage);
    }

}
