package HomeTask1;

/*
Написать программу, которая просит пользователя ввести электронный адрес и проверяет его на правильность
с помощью регулярных выражений Можно выбрать упрощенный вариант (без + в адресе)
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindEMail {


    static boolean proofEMail(String mail){
  String regex = "[a-zA-Z1-9]+([\\._]?+[a-zA-Z1-9])*@[a-zA-Z1-9]+([\\.-_]?[a-zA-Z1-9])*\\.[a-z]{2,4}";

        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
       return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите адрес электронной почты: ");
        String mail = scanner.nextLine();

        System.out.println(proofEMail(mail));

    }
}
