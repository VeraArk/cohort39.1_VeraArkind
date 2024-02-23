public class Task3 {

public static String encrypt(String text){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        sb.append((char)(text.charAt(i)+3));
    }
    return sb.toString();
}

    public static String decrypt(String data){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            sb.append((char)(data.charAt(i)-3));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
         String s = "Hello World";
        System.out.println("Input text "+ s);
        String enc = encrypt(s);
        System.out.println("Encrypted text "+ enc);
        String dec = decrypt(enc);
        System.out.println("Decrypted text "+ dec);

    }
}
