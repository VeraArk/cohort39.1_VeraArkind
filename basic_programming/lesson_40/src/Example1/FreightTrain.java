package Example1;
public class FreightTrain extends Vehicle implements CargoTransport {
    private int cartAmount;
    private double cargo;

    public FreightTrain(int cartAmount, double speed, double fuelPerKm) {
        super(speed, fuelPerKm);
        this.cartAmount = cartAmount;
        cargo = 0;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * (fuelPerKm + cartAmount * 0.1 * fuelPerKm + calculateCargoConsumptionPerKm());
    }

    @Override
    public double calculateCargoConsumptionPerKm() {
        return fuelPerKm * 0.00002 * cargo;
    }

    @Override
    public double getCargo() {
        return cargo;
    }

    @Override
    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
}