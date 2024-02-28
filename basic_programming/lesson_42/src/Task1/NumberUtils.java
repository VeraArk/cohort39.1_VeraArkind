package Task1;

public class NumberUtils {

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));
    }

    public static boolean isNarcissistic(int number) {

        String tempo = String.valueOf(number);
        int summ=0;
        int t;
        for (int i = 0; i < tempo.length(); i++) {
            t= Integer.parseInt(tempo.substring(i, i+1));
            summ+=Math.pow(t, tempo.length());
        }
        return summ==number;
    }

}