package Test;

public class Fish extends Animal{

    protected double length;
    protected String colour;

    public Fish(int age, String name) {
        super(age, name);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    }

