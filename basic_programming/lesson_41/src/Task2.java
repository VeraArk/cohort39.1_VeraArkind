import java.security.SecureRandom;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println(" vvedite stroke");
        String s = scanner.nextLine().toLowerCase();

        boolean isPalindrom = true;
        StringBuilder sb=new StringBuilder(s);
        if(sb.reverse().toString().equals(s)){
            System.out.println(isPalindrom);
        }
        else {
            System.out.println(!isPalindrom);
        }

        System.out.println(sb.reverse().toString().equals(s)? isPalindrom: !isPalindrom );
    }
}
