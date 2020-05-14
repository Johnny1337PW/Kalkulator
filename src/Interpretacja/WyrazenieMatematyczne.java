package Interpretacja;

public class WyrazenieMatematyczne extends OperacjaMatematycznaZNawiasami {
    //przyjmuje string np "( (4 +3)-2 )*7" i usuwa spacje"
    public String usunSpacje(String wyrazenie) {
        wyrazenie = wyrazenie.replace(" ","");
        return wyrazenie;
    }

    //przyjmuje string np "[(4+3)-2]*7" i podmienia wszystkie nawiasy na okrągłe"
    public String podmienNawiasy(String wyrazenie) {
        wyrazenie = wyrazenie.replace("[","(");
        wyrazenie = wyrazenie.replace("]",")");
        return wyrazenie;
    }

    //przyjmuje string np "((4+3)-2)*7" i oblicza wynik
    public Double obliczWyrazenie(String wyrazenie) {

        return 0.0;
    }
}
