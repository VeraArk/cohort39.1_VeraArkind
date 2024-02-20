package Example3;

public class NotificationManager {
    public static void broadcastMessage (Notifier notifier, String message){
        notifier.sentMessage(message);
    }
}
