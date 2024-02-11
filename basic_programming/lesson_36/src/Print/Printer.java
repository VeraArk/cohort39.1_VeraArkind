package Print;

abstract class Printer implements Machine{
    @Override
    public void print() {
        System.out.println("print");
    }
    @Override
    public void scan() {
        System.out.println("Scan");
    }
}
