public class FindOutlier {

    public static void main(String[] args) {
        int[] ar1 = {2, 6, 8, -10, 3};
        int[] ar2 = {Integer.MAX_VALUE, 0, 1};
        System.out.println(find(ar2));
        System.out.println(find(ar1));

    }

    static int find(int[] integers) {
        int oddCount = 0;
        int evenCount = 0;
        int tempo = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        if (evenCount == 1) {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 == 0) {
                    tempo = integers[i];
                    break;
                }
            }
        } else {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 != 0) {
                    tempo = integers[i];
                    break;
                }
            }
        }
        return tempo;
    }
}
