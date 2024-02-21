package Example1;

public class UsageTransport {
    public static void main(String[] args) {
        Car car = new Car("Audi", 120,  0.11);
        car.setPassengers(3);

        System.out.println("Для этого путешествия на автомобіле нужно "+ car.calculateFuelConsumption(600)+ " литров топлива.");

        FreightTrain train = new FreightTrain(50, 80, 0.2);
        train.setCargo(60_000);

        System.out.println("Для перевозки этого груза нужно "+ train.calculateFuelConsumption(600)+ " литров топлива.");


        Ferry ferry = new Ferry(50, 1.7, 17, 0.17);
        ferry.setPassengers(100);
        ferry.setAmountOfCars(20);

        System.out.println("Для перевозки на пароме людей и машин в указанном количестве нужно "+ ferry.calculateFuelConsumption(600)+ " литров топлива.");

    }
}

