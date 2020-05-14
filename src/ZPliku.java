import java.io.*;
import java.util.Scanner;

public class ZPliku {
    public static void czytaj(String filePath)  {

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            stringBuilder.append(line);
            fileReader.close();
            System.out.println("równanie z pliku to: ");
            System.out.println(stringBuilder.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Nie ma w tym katalogu takiego pliku, spróbuj jeszcze raz");
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
