package Task1;

import java.util.Scanner;

public class Main {
    public static double calculatePrise(double perimeter, double prisePerMetr) {
        return perimeter * prisePerMetr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Если вы хотите расчитать стоимость забора на участке, сообщите, какой формы ваш участок. " +
                "Если круглой, нажмите - 1, если прямоугольной  - 2, если многоугольной - 3: ");
        int choise = scanner.nextInt();
        System.out.println("Введите также стоимость метра забора в рублях: ");
        double prisePerMetr = scanner.nextDouble();


        switch (choise) {
            case 1: {
                System.out.println("Ведите радиус участка в метрах: ");
                double radius = scanner.nextDouble();
                Circle yourShane = new Circle(radius);
                double perimeter = yourShane.getPerimeter();
                double prise = calculatePrise(perimeter, prisePerMetr);
                System.out.println("Стоімость забора для вашего участка составляет " + prise);
                break;
            }
            case 2: {
                System.out.println("Ведите стороны вашего участка в метрах: ");
                scanner.nextLine();
                String sites = scanner.nextLine();
                String[] siteOfRectangle = sites.split(" ");
                Rectangle yourShane = new Rectangle(Double.parseDouble(siteOfRectangle[0]), Double.parseDouble(siteOfRectangle[1]));
                double perimeter = yourShane.getPerimeter();
                double prise = calculatePrise(perimeter, prisePerMetr);
                System.out.println("Стоімость забора для вашего участка составляет " + prise + " рублей.");
                break;
            }
            case 3: {
                System.out.println("Ведите сторону вашего участка в метрах: ");
                double site = scanner.nextDouble();
                System.out.println("Сколько сторон имеет участок: ");
                int amountOfSites = scanner.nextInt();
                Polygon yourShane = new Polygon(site, amountOfSites);
                double perimeter = yourShane.getPerimeter();
                double prise = calculatePrise(perimeter, prisePerMetr);
                System.out.println("Стоімость забора для вашего участка составляет " + prise);
                break;
            }
            default:  System.out.println("Вы ввелі неверное значение. К сожалению, мы не можем рассчитать цену для вашего участка");
        }
    }
}
