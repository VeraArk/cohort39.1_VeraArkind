package Example1;

public class Ferry extends Vehicle implements PeopleTransport, CargoTransport {

    private int amountOfCars;
    private double averageWeightOfCar;
    private int passengers;

    protected Ferry(int amountOfCars, double averageWeightOfCar, double speed, double fuelPerKm) {
        super(speed, fuelPerKm);
        this.amountOfCars = amountOfCars;
        this.averageWeightOfCar = averageWeightOfCar;
        passengers = 0;
    }


    @Override
    public double calculateFuelConsumption(double distance) {
        System.out.println("Путь займет " + distance / speed + "ч");
        return distance * (fuelPerKm + calculatePassengersConsumptionPerKm() + calculateCargoConsumptionPerKm());
    }

    @Override
    public double calculateCargoConsumptionPerKm() {
        return fuelPerKm * 0.00002 * amountOfCars * averageWeightOfCar;
    }

    @Override
    public double calculatePassengersConsumptionPerKm() {
        return passengers * 0.01 * fuelPerKm;
    }

    @Override
    public double getCargo() {
        return 0;
    }

    @Override
    public void setCargo(double cargo) {

    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }


    public int getAmountOfCars() {
        return amountOfCars;
    }

    public void setAmountOfCars(int amountOfCars) {
        this.amountOfCars = amountOfCars;
    }

    public double getAverageWeightOfCar() {
        return averageWeightOfCar;
    }

    public void setAverageWeightOfCar(double averageWeightOfCar) {
        this.averageWeightOfCar = averageWeightOfCar;
    }
}
