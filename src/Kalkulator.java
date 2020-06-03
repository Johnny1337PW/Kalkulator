import Interpretacja.Interpreter;
import View.Wypisz;
import Memory.Pamięć;

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

            if(input.equals("clear")) {
                Pamięć.wyczyscZmienne();
                Wypisz.wypiszWyczyszczenie();
                continue;
            }

            if(input.equals("list")) {
                Wypisz.wypiszZmienne(Pamięć.pobierzZmienne());
                continue;
            }

            Double wynik = Interpreter.interpretuj(input);
            if (wynik != null) {
                Wypisz.wypiszWynik(wynik);
                Wypisz.wypiszNowaLinie();
            }

        }

        Wypisz.wypiszPozegnanie("Brak błędów");
    }
}

