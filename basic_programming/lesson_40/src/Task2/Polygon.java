package Task2;

public class Polygon extends Shape {

    private double side;
    private int amountOfSide;

    public Polygon(double side, int amountOfSide) {
        this.side = side;
        this.amountOfSide = amountOfSide;
    }

    @Override
    public double getPerimeter() {
        return side * amountOfSide;
    }

    @Override
    public double resize(double coefficient) {
        return coefficient*getPerimeter();
    }
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public int getAmountOfSide() {
        return amountOfSide;
    }

    public void setAmountOfSide(int amountOfSide) {
        this.amountOfSide = amountOfSide;
    }


}
