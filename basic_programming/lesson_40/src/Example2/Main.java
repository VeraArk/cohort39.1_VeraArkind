package Example2;

public class Main {
    public static void main(String[] args) {
        Greeter english = new Greeter() {
            @Override
            public void printGreeteng() {
                System.out.println("Hello, World!");

            }
        };

        Greeter ruGreeter =new Greeter() {
            @Override
            public void printGreeteng() {
                System.out.println("Privet mir");
            }
        };
    }
}
