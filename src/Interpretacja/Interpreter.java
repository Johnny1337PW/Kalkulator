package Interpretacja;

import Memory.Pamięć;
import Plik.ZPliku;
import View.Wypisz;

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
                Wypisz.wypiszBlad("Błędny sposób użycia znaku \"!\"");
                return "0";
            }
        }
        return input;
    }

    public static String zamienStale(String input) {
        if(input.contains("@") && input.length() < 4) {
            Wypisz.wypiszBlad("Błąd przy użyciu stałej");
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
                            Wypisz.wypiszBlad("Błąd w użyciu stałej, źle ustawiony znak \"@\"");
                            return "0.0";
                        }
                    }
                    else {
                        Wypisz.wypiszBlad("Błąd w użyciu stałej, źle ustawiony znak \"@\"");
                        return "0.0";
                    }
                }
            }
        }
        return input;
    }

    public static String zamienZmienne(String input) {
        if(input.contains("&") && input.length() < 3) {
            Wypisz.wypiszBlad("Błąd przy użyciu zmiennej");
            return "0.0";
        }
        while(input.contains("&")) {
            int ind1 = input.indexOf('&');
            int ind2 = input.indexOf('&', ind1 + 1);
            String zmienna = input.substring(ind1 + 1, ind2);

            input = input.substring(0, ind1) + Pamięć.pobierzZmienna(zmienna) + input.substring(ind2 + 1);
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
            input = zamienZmienne(input);

            if(input.contains("=")) {
                int index = input.indexOf("=");
                String name = input.substring(0, index);
                String value = input.substring(index + 1);

                try {
                    Pamięć.dodajZmienna(name, Interpreter.interpretuj(value));
                }
                catch (NumberFormatException nfe){
                    Wypisz.wypiszBlad("Podano liczbę w błednym formacie");
                }
            }
            else {
                return obliczWyrazenie(input);
            }
        }
        else {
            Wypisz.wypiszBlad("Błąd w otwieraniu/zamykaniu nawiasów");
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
