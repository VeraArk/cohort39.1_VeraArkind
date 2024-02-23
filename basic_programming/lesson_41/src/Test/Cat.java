package Test;

public class Cat extends Animal{

    private String bread;




    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }
    public Cat(int age, String name, String bread) {
        super(age, name);
        this.bread=bread;

    }
}
