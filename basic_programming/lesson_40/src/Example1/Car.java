package Example1;
public class Car extends Vehicle implements PeopleTransport {
    String model;
    private int passengers;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(String model, double speed, double fuelAmount, double fuelPerKm) {
        super(speed, fuelAmount, fuelPerKm);
        this.model = model;
        passengers=0;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        System.out.println("Путь займет "+ distance/speed + " ч");
        return distance*(fuelPerKm+calculatePassengerConsumption());
    }


    @Override
    public double calculatePassengerConsumption() {
        return passengers*0.01*fuelPerKm;
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers=passengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
