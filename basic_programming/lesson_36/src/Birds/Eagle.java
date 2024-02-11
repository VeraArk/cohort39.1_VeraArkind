package Birds;

public class Eagle extends Bird {
    @Override
    void fly() {
        super.fly();
        System.out.println("Высота полета орлов составляет до 7-9 километров");
    }

    public static void main(String[] args) {
        Eagle petja = new Eagle();
        petja.fly();
    }
}