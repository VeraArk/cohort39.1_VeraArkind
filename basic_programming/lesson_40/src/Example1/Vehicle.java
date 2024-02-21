package Example1;
public abstract class Vehicle {
    protected double speed; // km/h

    protected double fuelPerKm;

    protected Vehicle(double speed, double fuelPerKm) {
        this.speed = speed;
        this.fuelPerKm = fuelPerKm;
    }

    public abstract double calculateFuelConsumption(double distance);

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }
}