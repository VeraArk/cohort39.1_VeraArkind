package Task2;

import java.util.Scanner;

public class Main {

    // метод для рассчета цены всего забора
    public static double calculatePrise(double perimeter, double prisePerMetr) {
        return perimeter * prisePerMetr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Если вы хотите расчитать стоимость забора на участке, сообщите, какой формы ваш участок. " +
                "Если круглой, нажмите - 1, если прямоугольной  - 2, если многоугольной - 3: ");
        int choise = scanner.nextInt();


        // ввожу переменные, чтобы считанные данные были видны и вне switch.
        double perimeter;
        double radius=0;
        double siteOfRectangleOne = 0;
        double siteOfRectangleTwo = 0;
        double siteOfPolygon = 0;
        int amountOfSites = 0;

        switch (choise) {
            case 1: {
                System.out.println("Ведите радиус участка в метрах: ");
                radius = scanner.nextDouble();
                Circle yourShane = new Circle(radius);
                perimeter = yourShane.getPerimeter();
                break;
            }
            case 2: {
                System.out.println("Ведите одну стороны вашего участка в метрах: ");
                scanner.nextLine();
                siteOfRectangleOne = scanner.nextDouble();
                System.out.println("Ведите одну стороны вашего участка в метрах: ");
                siteOfRectangleTwo = scanner.nextDouble();
                Rectangle yourShane = new Rectangle(siteOfRectangleOne, siteOfRectangleTwo);
                perimeter = yourShane.getPerimeter();
                break;
            }
            case 3: {
                System.out.println("Ведите сторону вашего участка в метрах: ");
                siteOfPolygon = scanner.nextDouble();
                System.out.println("Сколько сторон имеет участок: ");
                amountOfSites = scanner.nextInt();
                Polygon yourShane = new Polygon(siteOfPolygon, amountOfSites);
                perimeter = yourShane.getPerimeter();
                break;
            }
            default:
                System.out.println("Вы ввелі неверное значение. К сожалению, мы не можем рассчитать цену для вашего участка");
                return;
        }

        System.out.println("Введите также стоимость метра забора в рублях: ");
        double prisePerMetr = scanner.nextDouble();

        double prise = calculatePrise(perimeter, prisePerMetr);
        System.out.println("Стоімость забора для вашего участка составляет " + prise);

        System.out.println("Если вы хотите, увеличить размер участка и рассчитать новую стоимость забора, " +
                "введите коэффициент. Если не хотите введите 0");
        double coefficient = scanner.nextDouble();

        if(coefficient == 0){
            System.out.println("Спасібо, что выбралі нас");
            return;
        }

        double newPerimeter = 0;

        switch (choise) {
            case 1: {
                Circle newShane = new Circle(radius);
                newPerimeter = newShane.resize(coefficient);
                break;
            }
            case 2: {
                Rectangle newShane = new Rectangle(siteOfRectangleOne, siteOfRectangleTwo);
                newPerimeter = newShane.resize(coefficient);
                break;
            }
            case 3: {
                Polygon newShane = new Polygon(siteOfPolygon, amountOfSites);
                newPerimeter = newShane.resize(coefficient);
                break;
            }

        }
        double newPrise = calculatePrise(newPerimeter, prisePerMetr);
        System.out.println("Стоімость забора для вашего нового участка составляет " + newPrise);
    }
}
