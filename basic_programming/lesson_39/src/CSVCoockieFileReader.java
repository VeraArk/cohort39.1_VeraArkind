import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVCoockieFileReader implements CookieFileReader {
    @Override
    public Map<String, Integer> cookie(String pathToFile, String data) {
        Map<String, Integer> mapOfCooki = new HashMap<>();
        Integer tempoValue = 1;
        String cookie = null;
        String datai = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java_study\\study_homeWork\\Lesson35\\cookie"));
            String line = br.readLine();
            while (line != null) {
                int indexEnd= line.indexOf(",");
                cookie = line.substring(0, indexEnd);
                int indexEndOfDate= line.indexOf("T");
                datai = line.substring(indexEnd+1, indexEndOfDate+1);
                System.out.println(datai);
                if (data.equals(datai) && mapOfCooki.containsKey(cookie)){
                    int value = mapOfCooki.get(cookie);
                    mapOfCooki.put(cookie, value+1);
                }
                else if(data.equals(datai) && !mapOfCooki.containsKey(cookie)){
                    mapOfCooki.put(cookie, tempoValue);
                }
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapOfCooki;
    }
}
