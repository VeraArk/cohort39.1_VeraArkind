package Example1;
public class FreightTrain extends Vehicle implements CargoTransport {
    private double cargo;
    private int cartAmount;

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }


    public FreightTrain(int cartAmount, double speed, double fuelAmount, double fuelPerKm) {
        super(speed, fuelAmount, fuelPerKm);
        this.cartAmount = cartAmount;
        cargo=0;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance*(fuelPerKm+ cartAmount*0.1*fuelPerKm +calculateCargoConsumption());
    }

    @Override
    public double calculateCargoConsumption() {
        return fuelPerKm*0.00002*cargo;
    }

    @Override
    public void setCargo(double cargo) {
        this.cargo =cargo;
    }

    @Override
    public double getCargo() {
        return cargo;
    }
}
