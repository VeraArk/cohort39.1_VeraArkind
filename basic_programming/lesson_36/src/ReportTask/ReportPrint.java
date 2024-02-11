package ReportTask;

import java.io.FileInputStream;
import java.io.IOException;

public class ReportPrint extends Report {
    public static void main(String[] args) {

        try (FileInputStream printReport = new FileInputStream(report)) {
            int i;
            while ((i = printReport.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
