package practice.models;

// Модель
public class Reader {
    private String mail;
    private String password;

    public Reader(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
