
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

    public class TestForNewSet {
        @Test
        public void TestForIntercectName(){
            List<String> list1= List.of("Charlie", "Kate", "Sophi", "Cameron", "Alva", "Andrew");
            Set<String> listNameOne = new HashSet<>(list1);

            List<String> list2= List.of("Charlie", "Paul", "Peter", "Cameron", "John", "Jaff", "Andrew");
            Set<String> listNameTwo = new HashSet<>(list2);

            int resultSiseOfSet = 3;
            int expectedSiseOfSet = NewSet.intercectName(listNameOne,listNameTwo).size();

            Assertions.assertEquals(resultSiseOfSet,expectedSiseOfSet);

        }

        @Test
        public void TestForIntercectName2(){
            List<String> list1= List.of("Charlie", "Kate", "Sophi", "Cameron", "Alva", "Andrew");
            Set<String> listNameOne = new HashSet<>(list1);

            List<String> list2= List.of("Charlie", "Paul", "Peter", "Cameron", "John", "Jaff", "Andrew");
            Set<String> listNameTwo = new HashSet<>(list2);

            List<String> list3= List.of("Charlie", "Cameron", "Andrew");
            Set<String> result = new HashSet<>(list3);

            Set<String> expected = NewSet.intercectName(listNameOne,listNameTwo);
            expected.removeAll(result);

            Assertions.assertTrue(expected.isEmpty());
        }

    }


