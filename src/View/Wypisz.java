package View;

import java.util.HashMap;
import java.util.Map;

public class Wypisz {

    private static boolean czyTest = false;

    public static void setCzyTest(boolean czyTest) {
        Wypisz.czyTest = czyTest;
    }

    //przyjmuje liczbe i wypisuje ładnie
    public static void wypiszWynik(Double wynik) {
        if (wynik != null && !czyTest) {
            System.out.println("Wynik działania to: " + wynik);
        }
    }

    //powitanie
    public static void wypiszPowitanie(String dodatkowaWiadomosc) {
        if(!czyTest) {
            System.out.println("--------------------------------------");
            System.out.println("Witaj! Jestem Kalkulator PRM2T. ");
            System.out.println("Projekt stworzony przez: Jan Lewandowski, Jan Adamski, Tomasz Kapuściński");
            System.out.println("Aby zakończyć wpisz: \"exit\"");
            System.out.println("Aby uzyskać pomoc wpisz: \"help\"");
            System.out.println(dodatkowaWiadomosc);
            System.out.println("--------------------------------------");
        }
    }

    //pomoc
    public static void wypiszPomoc() {
        if(!czyTest) {
            System.out.println("--------------------------------------");
            System.out.println("Wykonuję obliczenia: +, -, /, * ");
            System.out.println("Potrafię obsługiwać zmienne - przykład użycia wpisanie: n = 2.5; i = 10; &i&*&n& -> zwroci wynik 25");
            System.out.println("Aby skorzystać z poniższych stałych wpisz @nazwa_stalej@ np. @pi@. Przykładowo @pi@*2 -> zwroci wynik 6.28318530718 ");
            System.out.println("Dostepne stale: Liczba pi - pi, Liczba eulera - ee, Stała eulera - eu, Złoty podział - fi");
            System.out.println("Dostepne stale: Stala Chinczyna - ch, Stała Apery'ego, Stała Mertensa stała Catalana");
            System.out.println("Dostepne stale: Stała Sierpińskiego - si, Stała Gaussa - ga, Stała Apery'ego - ap, Stała mertensa - mt, Stała Catalana - ct");
            System.out.println("Dostepne stale: Predkosc swiatla - cl, Masa unitu - un, Stała gazowa - nr, Przysp. ziemskie - gz");
            System.out.println("Dostepne stale: Stala Hubble'a - hu, Objętość molowa gazu w warunkach normalnych - om");
            System.out.println("Możesz wpisać dowolne działanie opierające się o te znaki w konsoli lub pliku txt. ");
            System.out.println("Aby uzyskać pomoc wpisz: \"help\"");
            System.out.println("Aby usunąć wszystkie zmienne wpisz: \"clear\"");
            System.out.println("Aby wypisać wszystkie zmienne wpisz: \"list\"");
            System.out.println("Aby zakończyć wpisz: \"exit\"");
            System.out.println("--------------------------------------");
        }
    }

    //pozegnanie
    public static void wypiszPozegnanie(String dodatkowaWiadomosc) {

        if(!czyTest) {
            System.out.println("--------------------------------------");
            System.out.println("Dziękujęmy za skorzystanie z naszego kalkulatora!");
            //System.out.println(dodatkowaWiadomosc);
            System.out.println("--------------------------------------");
        }

    }

    //wyczyszczenie zmiennych
    public static void wypiszWyczyszczenie() {

        if(!czyTest) {
            System.out.println("--------------------------------------");
            System.out.println("Wszystkie zmienne zostały usunięte");
            System.out.println("--------------------------------------");
        }

    }

    //wyczyszczenie zmiennych
    public static void wypiszZmienne(HashMap <String, Double> zmienne) {

        if(!czyTest) {
            System.out.println("--------------------------------------");
            System.out.println("Wszystkie zapisane zmienne:");
            for (Map.Entry<String, Double> entry : zmienne.entrySet()) {
                String name = entry.getKey();
                double value = entry.getValue();

                System.out.println(name + " = " + value);
            }
            System.out.println("--------------------------------------");
        }

    }

    public static void wypisz(String s) {
        if(!czyTest) {
            System.out.println(s);
        }
    }

    //blad
    public static void wypiszBlad(String bladInfo) {

        if(!czyTest) {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Ups... Niestety wykryto błąd: "+bladInfo);
            System.out.println("--------------------------------------");
        }

    }

    public static void wypiszNowaLinie() {
        if(!czyTest) {
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        String string = "błąd: dzielenie przez 0 \n" +
                        "błąd: nie wykonuję potęgowania \n" +
                        "błąd: aaa";
        wypiszPowitanie("Wersja 1.0");
        wypiszBlad("Podales nieprawidłowe działanie");
        wypiszWynik(19d);
        wypiszPozegnanie(string);
    }
}
