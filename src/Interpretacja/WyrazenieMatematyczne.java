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
        int id_end = 0;
        int id_start = 0;
        for (int i = 0; i < wyrazenie.length(); i++) {
            if (wyrazenie.charAt(i) == ')') {
                id_end = i;
                break;
            }
        }
        for (int i = id_end; i > 0; i--) {
            if (wyrazenie.charAt(i) == '(') {
                id_start = i;
                break;
            }
        }

        interpretujOperacje("4+3");

        //jezeli wyrazenie nie ma zadnych znakow oprocz liczb to zwroc wynik
        if (false) {
            return Double.valueOf(wyrazenie);
        }

        obliczWyrazenie("");

        return 0.0;
    }
}
