package Interpretacja;

public class Interpreter extends WyrazenieMatematyczne {

    public static double interpretuj(String input)
    {
        if(sprawdzNawiasy(input)) {
            input = usunSpacje(input);
            input = podmienNawiasy(input);
            return obliczWyrazenie(input);
        }
        else {
            System.out.println("Błąd w otwieraniu/zamykaniu nawiasów");
        }

        return 0.0;
    }

}
