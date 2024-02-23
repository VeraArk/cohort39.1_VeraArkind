import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineConverter {
    /*
    Написать два метода, один из которых преобразует строку из обычного предложения в стиль lowerCamelCase,
    а другой сделает обратное действие. Например, для строки "Какой замечательный, однако, день!" результатом будет
    "какойЗамечательныйОднакоДень". Обратите внимание, что все символы, которые не разрешаются в идентификаторах,
    должны удаляться. Если результат этого
    метода превратить с помощью второго метода, должно получиться "Какой замечательный однако день"

     */
    static String camelCase(String text) {
        String regex = "[!-/,?\\.]*";
        text = text.replaceAll(regex, "");
        StringBuilder stb = new StringBuilder();

        String[] arr = text.split(" ");

        stb.append(arr[0].toLowerCase());
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                arr[i] = arr[i].replaceFirst(arr[i].substring(0,1), arr[i].substring(0,1).toUpperCase());
                stb.append(arr[i]);
            }
        }
        return stb.toString();
    }


//    static String backCentence(String text) {
//
//
//        StringBuilder stb =  new StringBuilder();
//        String regex = "[А-Я]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(text);
//        int tempoIndex=0;
//
//        while (matcher.find()) {
//
//            int i = matcher.start();
//             String tempo = text.substring(tempoIndex, i);
//             System.out.println(tempo);
//             tempoIndex=i;
//
//            stb.append(tempo.toLowerCase());
//
//          text = text.substring(i).replace(text.substring(0, 0), (text.substring(0, 0).toLowerCase()));
//
//        }
//        return stb.toString();
//    }


    public static void main(String[] args) {

        String str = "Какой замечательный, однако, день!";
        String oneWort = camelCase(str);
        System.out.println(oneWort);
//        String sentenceAgain = backCentence(oneWort);
//        System.out.println(sentenceAgain);

    }
}
