
public class CheckFormater {
    public static CookieFileReader courceChecker(String path) {
        if (path.endsWith(".csv")) {
            return new CSVCoockieFileReader();
        } else if (path.endsWith(".json")) {
            return new JSONCoockieFileReader();
        } else return new ExceptionCookieFileReader();
    }
}
