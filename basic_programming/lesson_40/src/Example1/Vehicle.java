package Example1;
public abstract class Vehicle {

    protected double speed; // km/h
    protected double fuelAmount; // l
    protected double fuelPerKm;

    public double getSpeed() {
        return speed;
    }

    protected Vehicle(double speed, double fuelAmount, double fuelPerKm) {
        this.speed = speed;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
    }

    public abstract double calculateFuelConsumption (double distance);

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public abstract double calculatePassengerConsumption();

    public abstract void setPassengers(int passengers);

    public abstract int getPassengers();
}
