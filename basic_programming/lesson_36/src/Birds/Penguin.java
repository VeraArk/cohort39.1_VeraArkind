package Birds;

public class Penguin extends Bird {
    @Override
    void fly() {
        super.fly();
        System.out.println("Но пингвин - исключение. Он не летает");
    }

    public static void main(String[] args) {
        Penguin vova = new Penguin();
        vova.fly();
    }
}
