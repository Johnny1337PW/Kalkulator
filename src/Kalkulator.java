import Interpretacja.Interpreter;

import java.util.Scanner;

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

            Wypisz.wypiszWynik(Interpreter.interpretuj(input));
            Wypisz.wypiszNowaLinie();
        }

        Wypisz.wypiszPozegnanie("brak błędów");
    }
}

