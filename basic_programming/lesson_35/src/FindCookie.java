import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindCookie {
    public static void main(String[] args) {
        ArrayList<String> coocieArray = new ArrayList<>();
// считываем информацию из файла и помещаем ее в ArrayList. каждый элемент куки+дата
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java_study\\study_homeWork\\Lesson35\\cookie"));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                coocieArray.add(line);
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate needsDate = LocalDate.of(2018, 12, 9);
        ArrayList<String> justCoocieOfDay = findCookiesOfDay(coocieArray, needsDate);
        Map<String, Integer> effektivCooki = findPopularCookiesOfDay(justCoocieOfDay);
        findAndShow(effektivCooki);


    }

    // в отдельном методе создаем отдельный массів кукі для нужного чісла, отсекаем другіе даты

    public static ArrayList<String> findCookiesOfDay(ArrayList<String> coocieArray, LocalDate needsDate) {

        ArrayList<String> justCoocieOfDay = new ArrayList<>();
        for (int i = 0; i < coocieArray.size(); i++) {
            String element = coocieArray.get(i);
            int indexBeginn = element.indexOf(',');
            int indexEnd = element.indexOf('T');
            String data = element.substring(indexBeginn + 1, indexEnd);

            // выделяем дату из строки и соотносим с нужной датой. подходящие элементы складываем во второй массив

            LocalDate parsedDate = LocalDate.parse(data, DateTimeFormatter.ISO_LOCAL_DATE);
            if (parsedDate.equals(needsDate)) {
                justCoocieOfDay.add(element.substring(0, indexBeginn - 1));
            }
        }
        return justCoocieOfDay;
    }

    // метод для нахожденія наиболее часто встречающегося элемента в массиве с кукі от нужного чісла

    public static Map<String, Integer> findPopularCookiesOfDay(ArrayList<String> justCoocieOfDay) {
        Map<String, Integer> effektivCooki = new HashMap<>();
        int work = 1;
        for (int i = 0; i < justCoocieOfDay.size(); i++) {
            String tempo = justCoocieOfDay.get(i);
            for (int j = i + 1; j < justCoocieOfDay.size(); j++) {
                if (tempo.equals(justCoocieOfDay.get(j))) {
                    work++;
                }
            }
            effektivCooki.putIfAbsent(justCoocieOfDay.get(i), work);
            work = 1;
        }
        return effektivCooki;
    }

    public static void findAndShow(Map<String, Integer> effektivCooki) {
        int max =0;
        Set<Map.Entry<String, Integer>> entrySet = effektivCooki.entrySet();
        for (Map.Entry<String, Integer> pair : entrySet) {
            if(max< pair.getValue()){
                max= pair.getValue();
            }}
        for (Map.Entry<String, Integer> pair : entrySet){
            if(pair.getValue()== max){
                System.out.printf("Наиболее эффективный куки %s. Oн срабытывает %d раз", pair.getKey(), pair.getValue());
            }
        }
    }
}
