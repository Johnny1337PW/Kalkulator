package Interpretacja;

import Memory.Pamięć;
import Plik.ZPliku;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter extends WyrazenieMatematyczne {

    public static String przygotuj(String input) {
        input = podmienZPliku(input);
        return input;
    }

    public static String podmienZPliku(String input) {
        if (input.contains("!")) {
            Pattern compiledPattern = Pattern.compile("!\\(.*\\)");
            Matcher matcher = compiledPattern.matcher(input);

            if (matcher.matches()) {
                return ZPliku.czytaj(input.substring(2, input.length() - 1));

            }
            else {
                System.out.println("Błędny sposób użycia znaku \"!\"");
                return "0";
            }
        }
        return input;
    }

    public static String zamienStale(String input) {
        if(input.contains("@") && input.length() < 4) {
            System.out.println("Błąd przy użyciu stałej");
            return "0.0";
        }
        while(input.contains("@")) {
            for (int i = input.length() - 1; i >= 0; i--) {
                if (input.charAt(i) == '@') {
                    if(i - 3 >= 0) {
                        if (input.charAt(i - 3) == '@') {
                            input = input.replace(input.substring(i - 3, i + 1), String.valueOf(Pamięć.getConstant(input.substring(i - 2, i))));
                        }
                        else {
                            System.out.println("Błąd w użyciu stałej, źle ustawiony znak \"@\"");
                            return "0.0";
                        }
                    }
                    else {
                        System.out.println("Błąd w użyciu stałej, źle ustawiony znak \"@\"");
                        return "0.0";
                    }
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
        podmienZPliku("!(test/test");
    }

}
