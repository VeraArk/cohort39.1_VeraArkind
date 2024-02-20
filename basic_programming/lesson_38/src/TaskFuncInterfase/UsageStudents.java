
package TaskFuncInterfase;

import java.util.ArrayList;

public class UsageStudents  {


    public static void main(String[] args) {

        Student st1 = new Student("Vera", 7.2, 2);
        Student st2 = new Student("Max", 6.2, 3);
        Student st3 = new Student("Sophia", 9.4, 4);
        Student st4 = new Student("Alex", 8.5, 2);
        Student st5 = new Student("Grieg", 7.9, 1);

        ArrayList<Student> groupOfStudents = new ArrayList<>();
        groupOfStudents.add(st1);
        groupOfStudents.add(st2);
        groupOfStudents.add(st3);
        groupOfStudents.add(st4);
        groupOfStudents.add(st5);

        UsageStudents info = new UsageStudents();

        // моя ІДЕЯ все-таки не дружит с лямбда-выражениями и опять выдает ошибку (которой, на мой взгляд, быть не должно)
        //ЛІБО я все-таки делаю массу ошибок (!!!!!!)
        // первый метод находит студентов с оценкой выше 9 (использует интерфейс Conditional ( аналог Predicate)):

        info.findStudentWithNoteAboveNine(groupOfStudents, (Student st) -> {
            return st.getNote() > 9;
        });

        // второй метод переводит всех студентов на следующий курс. Использует интерфейс Action (аналог Consumer)

        info.changeGroup(groupOfStudents, (Student st) -> {
            st.getCourse() += 1;
            System.out.printf("Студент %s переведен на %d курс\n",
                    st.getName(), st.getCourse());
        });


        // метод случайным образом выбирает дежурного Provider (аналог Supplier)

        String onDuty = Provider(() -> {
            int random = (int) (Math.random() * groupOfStudents.size());
            return groupOfStudents.get(random); };

        System.out.println("Сегодня дежуріт " + onDuty);
    }


    public void findStudentWithNoteAboveNine(ArrayList<Student> list, Condition isFit) {
        System.out.print("Оценка 9+ у студентов: ");
        for (Student st : list) {

            if (isFit.test(st)) {
                System.out.println(st.getName() + ". У этого студента средняя оценка " + st.getNote());
            }
        }
    }

    public void changeGroup(ArrayList<Student> groupOfStudents, Action<Student> course) {
        for (Student st : groupOfStudents
        ) {
            course.execute(st);
        }
    }

}



