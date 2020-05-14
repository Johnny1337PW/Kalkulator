import Interpretacja.Interpreter;

public class Kalkulator {
    public void start() {
        Wypisz.wypiszPowitanie("Wersja 1.0");

        Interpreter.interpretuj();

        Wypisz.wypiszPozegnanie("brak błędów");
    }
}

