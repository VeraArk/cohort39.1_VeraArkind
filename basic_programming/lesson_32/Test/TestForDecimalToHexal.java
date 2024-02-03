
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestForDecimalToHexal {
    @Test
    public void TestForRbc() {

        int[] ar1 = {17, 135, 200};
        int[] ar2 = {0, 0, 0};
        int[] ar3 = {-1, -17, 200};
        int[] ar4 = {100, 189, 700};
        int[] ar5 = {900, 576, 700};

        String expected1 = "1187C8";
        String expected2 = "000000";
        String expected3 = "0000C8";
        String expected4 = "64BDFF";
        String expected5 = "FFFFFF";

        Assertions.assertEquals(expected1, DecimalToHexal.rgb(ar1));
        Assertions.assertEquals(expected2, DecimalToHexal.rgb(ar2));
        Assertions.assertEquals(expected3, DecimalToHexal.rgb(ar3));
        Assertions.assertEquals(expected4, DecimalToHexal.rgb(ar4));
        Assertions.assertEquals(expected5, DecimalToHexal.rgb(ar5));
    }
}
