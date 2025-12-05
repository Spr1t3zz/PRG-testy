public class Boat extends Vehicle {

    public Boat(int kapacitaNadrze, int aktualniMnozstvi) {
        super(kapacitaNadrze, aktualniMnozstvi);
    }

    @Override
    public void move() {
        System.out.println("The boat has moved");
    }

}
