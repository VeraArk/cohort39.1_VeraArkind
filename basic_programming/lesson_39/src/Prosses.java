import java.util.Map;

public class Prosses {
    public static void main(String[] args) {
        CookieFileReader fileReader = CheckFormater.courceChecker("D://Java_study//cohort39.1_VeraArkind//basic_programming//lesson_39//src//cookie.json");

        Map<String, Integer> mapOfCookie = CookieFileReader.cookie("D://Java_study//cohort39.1_VeraArkind//basic_programming//lesson_39//src//cookie.json", "2018-12-09");

        System.out.println(mapOfCookie);
    }

}

