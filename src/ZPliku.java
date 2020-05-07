import java.io.*;
import java.util.Scanner;

public class ZPliku {
    public static void czytaj()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ścieżkę do pliku txt: ");
        String filePath = scanner.nextLine();
        System.out.println("Podaj nazwę pliku txt (bez rozszerzenia): ");
        String fileName = scanner.nextLine();
        System.out.println("Path: "+filePath + '\\' + fileName+".txt");
        try {
            File file = new File(filePath + '\\' + fileName+".txt");
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
    czytaj();
    }
}
