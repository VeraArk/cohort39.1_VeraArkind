import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

    public class MapExample {
        public static void main(String[] args) {


            // Ключ - номер водітельсеого удостоверенія. Значение - имя
            Map<Integer, String> driverList = new HashMap<>();
            driverList.put(11234, "Vera");
            driverList.put(11235, "Petr");
            driverList.put(11236, "Sophia");
            driverList.put(11237, "Alex");
            driverList.put(null, "Jane");
            driverList.put(11238, "Vera");
            driverList.put(11239, "Alex");
            driverList.put(11240, null);
            driverList.entrySet();

            System.out.println(driverList);
            Map<Integer, String> driverList2 = removeSameValues(driverList);
            System.out.println(driverList2);
        }

        public static Map removeSameValues(Map<Integer, String> map) {
            Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
//        Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> pair = it.next();
                int summ = 0;
                for (Map.Entry <Integer, String> pair2 : map.entrySet()
                ) {
                    if (!(pair.getValue() == null) && !(pair2.getValue() == null) && pair.getValue().contains(pair2.getValue())) {
                        summ++;
                    } else if (pair2.getValue() == null && pair.getValue() == null) {
                        summ++;
                    }
                }
                if (summ > 1) {
                    map.remove(pair);
                }
            }
            return map;
        }
    }


