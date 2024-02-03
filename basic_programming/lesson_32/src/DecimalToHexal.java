
public class DecimalToHexal {
    public static void main(String[] args) {
        int[] ar1 = {312, 255, 255};
        int[] ar2 = {294, 302, 255};
        int[] ar3 = {0, -1, 0};

        String firstNumber = rgb(ar1);
        String secondNumber = rgb(ar2);
        String thirthNumber = rgb(ar3);

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirthNumber);

    }

    public static String rgb(int[] ar) {
        String hexalNumber = "";
        int tempoForFindingRest = 0;
        int tempoArrayElement = 0;
        int rest = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < 0) {
                ar[i] = 0;
            } else if (ar[i] > 255) {
                ar[i] = 255;
            }
            tempoArrayElement = ar[i];
            do {
                tempoForFindingRest = tempoArrayElement / 16;
                rest = tempoArrayElement % 16;
                if (tempoForFindingRest > 9) {
                    switch (tempoForFindingRest) {
                        case 10:
                            hexalNumber = hexalNumber.concat("A");
                            break;
                        case 11:
                            hexalNumber = hexalNumber.concat("B");
                            break;
                        case 12:
                            hexalNumber = hexalNumber.concat("C");
                            break;
                        case 13:
                            hexalNumber = hexalNumber.concat("D");
                            break;
                        case 14:
                            hexalNumber = hexalNumber.concat("E");
                            break;
                        case 15:
                            hexalNumber = hexalNumber.concat("F");
                    }
                } else {
                    hexalNumber = hexalNumber.concat(String.valueOf(tempoForFindingRest));
                }
                tempoArrayElement = ar[i] - (rest * tempoForFindingRest);
            }
            while (rest > 16);
            if (rest > 9) {
                switch (rest) {
                    case 10:
                        hexalNumber = hexalNumber.concat("A");
                        break;
                    case 11:
                        hexalNumber = hexalNumber.concat("B");
                        break;
                    case 12:
                        hexalNumber = hexalNumber.concat("C");
                        break;
                    case 13:
                        hexalNumber = hexalNumber.concat("D");
                        break;
                    case 14:
                        hexalNumber = hexalNumber.concat("E");
                        break;
                    case 15:
                        hexalNumber = hexalNumber.concat("F");
                }
            } else {
                hexalNumber = hexalNumber.concat(String.valueOf(rest));
            }
        }
        return hexalNumber;
    }
}


