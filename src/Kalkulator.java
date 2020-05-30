import Interpretacja.Interpreter;
import View.Wypisz;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Kalkulator {
    public void start() {
        Wypisz.wypiszPowitanie("Wersja 1.0");

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(true) {
            input = scanner.nextLine();

            if(input.equals("exit")) {
                break;
            }

            if(input.equals("help")) {
                Wypisz.wypiszPomoc();
                continue;
            }

            if(input.contains(";")) {
                Pattern p = Pattern.compile(";");
                String[] linie = p.split(input);
                for(String linia : linie) {
                    Wypisz.wypiszWynik(Interpreter.interpretuj(linia));
                    Wypisz.wypiszNowaLinie();
                }
            }
            else {
                Wypisz.wypiszWynik(Interpreter.interpretuj(input));
                Wypisz.wypiszNowaLinie();
            }
        }

        Wypisz.wypiszPozegnanie("brak błędów");
    }
}

