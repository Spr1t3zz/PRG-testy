public class Plane extends Vehicle {

    public Plane(int kapacitaNadrze, int aktualniMnozstvi) {
        super(kapacitaNadrze, aktualniMnozstvi);
    }

    @Override
    public void move() {
        System.out.println("The plane has moved");
    }

}
