package TaskFuncInterfase;

public class Student {
    private String name;
    private double note;
    private int course;


    public Student(String name, double note, int course) {
        this.name = name;
        this.note = note;
        this.course=course;

    }
    public String getName() {
        return name;
    }

    public double getNote() {
        return note;
    }

    public int getCourse() {
        return course;
    }
}

