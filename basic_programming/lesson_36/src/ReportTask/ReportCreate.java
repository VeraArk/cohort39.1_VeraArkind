package ReportTask;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReportCreate extends Report {
    public static void main(String[] args) {
        try (FileOutputStream createReport = new FileOutputStream(report)) {
            String textReport = "Report info";
            createReport.write(textReport.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

