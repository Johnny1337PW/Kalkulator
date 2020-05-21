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
            return stringBuilder.toString();

        } catch (FileNotFoundException e) {
            System.out.println("Nie istnieje plik o takiej ścieżce");
            return "0";
        }
        catch (IOException e ){
            e.printStackTrace();
            return "0";
        }
    }

    public static void main(String[] args) {
        czytaj("src/dzialanie.txt");//tu wpisujemy argument metody - sciezke do pliku. Do każdego slasha "\" należy dodać jeszcze jeden slash "\\"
    }
}
