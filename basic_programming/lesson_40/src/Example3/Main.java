package Example3;

public class Main {
    public static void main(String[] args) {
        Notifier telegramNotifier = new Notifier() {
            @Override
            public void sentMessage(String text) {
                System.out.println("Sending message vie Telegram: "+ text);
            }
        };

        NotificationManager.broadcastMessage(new EmailNotiefier(), "Hello per Email");
        NotificationManager.broadcastMessage(new SmsNotifier(), "Hello per SMS");
        NotificationManager.broadcastMessage( telegramNotifier, "Hello per Telegram");
    }
}
