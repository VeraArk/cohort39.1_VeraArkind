

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForBracket {
    @Test
    public void testCheckOrder (){
        String st1 = "(Hello) Welt!";
        String st2= "({[Hello Welt!]})";
        String st3= "Hello Welt!";
        String st4 = "({Hello Welt!})";

        String st5= "(Hello Welt!})";
        String st6= "({[Hello Welt!}])";
        String st7 = "(Hello Welt!";


        Assertions.assertTrue(Bracket.checkOrder(st1));
        Assertions.assertTrue(Bracket.checkOrder(st2));
        Assertions.assertTrue(Bracket.checkOrder(st3));
        Assertions.assertTrue(Bracket.checkOrder(st4));

        Assertions.assertFalse(Bracket.checkOrder(st5));
        Assertions.assertFalse(Bracket.checkOrder(st6));
        Assertions.assertFalse(Bracket.checkOrder(st7));

    }
}

