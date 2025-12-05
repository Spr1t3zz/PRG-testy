public abstract class Unit {

    protected String name;
    protected int health;
    protected int damage;

    public Unit(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }


    public abstract void attack(Unit target);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
            System.out.println(this.name + " died");
        }
        System.out.println(this.name + " got hit with " + damage+ " points of damage. Health after sustaining injuries " + this.health);
    }


}
