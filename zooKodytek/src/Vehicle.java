public abstract class Vehicle {

    protected int kapacitaNadrze;
    protected int aktualniMnozstvi;

    public Vehicle (int kapacitaNadrze, int aktualniMnozstvi) {
        this.aktualniMnozstvi = aktualniMnozstvi;
        this.kapacitaNadrze = kapacitaNadrze;
    }

    public abstract void move();

    public void refuel() {
        if (aktualniMnozstvi < kapacitaNadrze) {

            int doplnit = kapacitaNadrze - aktualniMnozstvi;
            aktualniMnozstvi += doplnit;

            System.out.println("Palivo bylo refueled, ted mate " + aktualniMnozstvi);
        } else {
            System.out.println("Mate dost paliva, vic nepotrebujete");
        }
    }



}
