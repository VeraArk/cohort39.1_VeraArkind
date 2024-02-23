public class Main_01 {
    public static void main(String[] args) {
        int ar[] = new int[50];
        for (int i = 0; i < ar.length; i++) {
            ar[i]= i+1;
        }

        long start = System.nanoTime();
        String result = "[ ";

        for (int i = 0; i < ar.length; i++) {
            result +=ar[i];
            if(i+1 != ar.length){
                result += ", ";
            }
        }

        result+= "]";
        long end = System.nanoTime();

        System.out.println((end-start)/ 1000);
        long start1 = System.nanoTime();

        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < ar.length; i++) {
           sb.append(ar[i]);
            if(i+1 != ar.length){
                sb.append(", ");
            }
        }
        sb.append("]");
        long end2 = System.nanoTime();
        System.out.println((end2-start1)/ 1000);;

    }
}
