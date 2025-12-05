public class Car extends Vehicle {

    public Car(int kapacitaNadrze, int aktualniMnozstvi) {
        super(kapacitaNadrze, aktualniMnozstvi);
    }

    @Override
    public void move() {
        System.out.println("The car has moved");
    }

}
