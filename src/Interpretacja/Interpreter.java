package Interpretacja;

import Memory.Pamięć;

public class Interpreter extends WyrazenieMatematyczne {

    public static String przygotuj(String input) {
        return input;
    }

    public static String zamienStale(String input) {
        if(input.contains("@") && input.length() < 4) {
            System.out.println("Błąd przy użyciu stałej");
            return "0.0";
        }

        for (int i = input.length() - 1; i > 0; i--) {
            if (input.charAt(i) == '@') {
                if (input.charAt(i - 3) == '@') {
                    input = input.replace(input.substring(i - 3, i + 1), String.valueOf(Pamięć.getConstant(input.substring(i - 2, i))));
                }
                else {
                    System.out.println("Błąd w użyciu stałej, źle ustawiony znak \"@\"");
                    return "0.0";
                }
            }
        }
        return input;
    }

    public static double interpretuj(String input)
    {
        input = przygotuj(input);

        if(sprawdzNawiasy(input)) {
            input = usunSpacje(input);
            input = podmienNawiasy(input);
            input = zamienStale(input);
            return obliczWyrazenie(input);
        }
        else {
            System.out.println("Błąd w otwieraniu/zamykaniu nawiasów");
        }

        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(zamienStale("@pi@"));
        System.out.println(zamienStale("@@"));
        System.out.println(zamienStale("@pi@ + @ee@"));
    }

}
