package Plik;

import java.io.*;

public class ZPliku {
    public static String czytaj(String filePath)  {
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            stringBuilder.append(line);
            fileReader.close();
            System.out.println("równanie z pliku to: " + stringBuilder.toString());
            return stringBuilder.toString();

        } catch (FileNotFoundException e) {
            System.out.println("Nie ma w tym katalogu takiego pliku, spróbuj jeszcze raz");
        }
        catch (IOException e ){
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        czytaj("src/dzialanie.txt");//tu wpisujemy argument metody - sciezke do pliku. Do każdego slasha "\" należy dodać jeszcze jeden slash "\\"
    }
}
