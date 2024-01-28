import java.util.HashMap;
import java.util.Map;
import java.util.Set;


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
        Map<Integer, String> mapTempo = new HashMap<>();
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> pair : entrySet) {
            if (!mapTempo.containsValue(pair.getValue())) {
                mapTempo.put(pair.getKey(), pair.getValue());
            }

        }
        return mapTempo;
    }
}



