


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TastOfStreamAPI {

    // Цикл для фильтрации элементов:
    static void firstTask() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(input.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));


        //System.out.println(output);
    }

    // Цикл для преобразования элементов:
    static void secondTask() {
        List<String> fruit = Arrays.asList("apple", "banana", "cherry");
        // Stream stream2 = fruit.stream();

        //List<Integer> lengthOfNamenFruit = stream2.map(el -> el.length()).collect(Collectors.toList());

        System.out.println(fruit.stream().map(el -> el.length()).collect(Collectors.toList()));

        //System.out.println(lengthOfNamenFruit);

    }
    //        Цикл для подсчета элементов, удовлетворяющих условию:
    static void thirdTask() {
        List<Integer> input3 = Arrays.asList(1, 2, 3, 4, 5);
        Stream list = input3.stream();


        System.out.println(input3.stream().filter(e -> e % 2 == 0).reduce((e1, e2) -> e1 + e2).get());
    }

    public static void main(String[] args) {

        firstTask();
        secondTask();
        thirdTask();

    }
}


