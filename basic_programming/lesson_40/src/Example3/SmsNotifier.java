package Example3;

public class SmsNotifier implements Notifier{

    @Override
    public void sentMessage(String text) {
        System.out.println("Sending message vie SMS: "+ text);
    }
}
