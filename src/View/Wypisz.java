package View;

public class Wypisz {
    //przyjmuje liczbe i wypisuje ładnie
    public static void wypiszWynik(double wynik) {

        System.out.println("Wynik działania to: " + wynik);

    }

    //powitanie
    public static void wypiszPowitanie(String dodatkowaWiadomosc) {

        System.out.println("--------------------------------------");
        System.out.println("Witaj! Jestem Kalkulator PRM2T. ");
        System.out.println("Projekt stworzony przez: Jan Lewandowski, Jan Adamski, Tomasz Kapuściński");
        System.out.println("Aby zakończyć wpisz: \"exit\"");
        System.out.println("Aby uzyskać pomoc wpisz: \"help\"");
        System.out.println(dodatkowaWiadomosc);
        System.out.println("--------------------------------------");

    }

    //pomoc
    public static void wypiszPomoc() {
        System.out.println("--------------------------------------");
        System.out.println("Wykonuję obliczenia + - / * ");
        System.out.println("Dostepne stale: Liczba pi - pi, Liczba eulera - ee, Stała eulera - eu, Złoty podział - fi");
        System.out.println("Dostepne stale: Stala Chinczyna - ch, Stała Apery'ego, Stała Mertensa stała Catalana");
        System.out.println("Dostepne stale: Stała Sierpińskiego - si, Stała Gaussa - ga, Stała Apery'ego - ap, Stała mertensa - mt, Stała Catalana - ct");
        System.out.println("Dostepne stale: Predkosc swiatla - cl, Masa unitu - un, Stała gazowa - nr, Przysp. ziemskie - gz");
        System.out.println("Dostepne stale: Stala Hubble'a - hu, Objętość molowa gazu w warunkach normalnych - om");
        System.out.println("Możesz wpisać dowolne działanie opierające się o te znaki w konsoli lub pliku txt. ");
        System.out.println("Aby zakończyć wpisz: \"exit\"");
        System.out.println("Aby uzyskać pomoc wpisz: \"help\"");
        System.out.println("--------------------------------------");
    }

    //pozegnanie
    public static void wypiszPozegnanie(String dodatkowaWiadomosc) {

        System.out.println("--------------------------------------");
        System.out.println("Dziękuję za skorzystanie z usług kalkulatora!");
        //System.out.println(dodatkowaWiadomosc);
        System.out.println("--------------------------------------");

    }

    //blad
    public static void wypiszBlad(String bladInfo) {

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Ups... Niestety wykryto błąd: "+bladInfo);
        System.out.println("--------------------------------------");

    }

    public static void wypiszNowaLinie() {
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        String string = "błąd: dzielenie przez 0 \n" +
                        "błąd: nie wykonuję potęgowania \n" +
                        "błąd: aaa";
        wypiszPowitanie("Wersja 1.0");
        wypiszBlad("podales zle dzialanie");
        wypiszWynik(19);
        wypiszPozegnanie(string);
    }
}
