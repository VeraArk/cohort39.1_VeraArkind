package Example3;

public class EmailNotiefier implements Notifier{
    @Override
    public void sentMessage(String text) {
        System.out.println("Sending message vie eMail: "+ text);
    }
}
