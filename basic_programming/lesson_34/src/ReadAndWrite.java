import java.io.*;

public class ReadAndWrite {
    /*
    Реализуйте чтение входных данных из файла и вывод
    результата в другой файл, чтобы попрактиковаться в работе
    с файловым вводом/выводом в Java.
     */

    public static void main(String[] args) throws IOException {

        File file2 = new File("fileForPractice2.txt");

//        запись в файл без try with recourse

        FileOutputStream info = new FileOutputStream("fileForPractice.txt");
        String s = "this is text for example. I try to write\n";
        info.write(s.getBytes());
        info.close();

        //        запись в файл c try with recourse
        try (FileOutputStream info2 = new FileOutputStream("fileForPractice2.txt")) {
            String s2 = "this is the second attempt anything to write\n";
            info2.write(s2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // чтение из одного файла и копирование в другой

        try (FileInputStream info3 = new FileInputStream("fileForPractice.txt");
             FileInputStream info4 = new FileInputStream("fileForPractice2.txt");
             FileOutputStream info5 = new FileOutputStream("fileForPractice3.txt")){

            int i;
            while ((i=info3.read())!=-1){
                info5.write(i);
            }

            int j;
            while ((j=info4.read())!=-1){
                info5.write(j);
            }

        }

    }
}