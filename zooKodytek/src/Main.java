import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Vehicle bike = new Bike(0,0);
        Vehicle car = new Car(50, 50);
        Vehicle plane = new Plane(100, 100);
        Vehicle boat = new Boat(40,40);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(bike);
        vehicles.add(car);
        vehicles.add(plane);
        vehicles.add(boat);

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }

        //33%
    }
}
