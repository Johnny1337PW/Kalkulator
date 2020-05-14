import Interpretacja.Interpreter;

import java.util.Scanner;

public class Kalkulator {
    public void start() {
        Wypisz.wypiszPowitanie("Wersja 1.0");

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(!input.equals("exit")) {
            input = scanner.nextLine();
            Interpreter.interpretuj(input);
        }

        Wypisz.wypiszPozegnanie("brak błędów");
    }
}

