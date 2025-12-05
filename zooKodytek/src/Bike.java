public class Bike extends Vehicle {

    public Bike(int kapacitaNadrze, int aktualniMnozstvi) {
        super(kapacitaNadrze, aktualniMnozstvi);
    }

    @Override
    public void move() {
        System.out.println("The bike has moved");
    }


}
