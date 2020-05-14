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
                id_end = i+1;
                break;
            }
        }
        for (int i = id_end; i > 0; i--) {
            if (wyrazenie.charAt(i) == '(') {
                id_start = i;
                break;
            }
        }
        String dzialanie = wyrazenie.substring(id_start, id_end);
        String wynik = String.valueOf(interpretujOperacje(dzialanie.substring(1,dzialanie.length()-1)));
        String finalny = wyrazenie.substring(0,id_start);
        finalny += wynik;
        finalny += wyrazenie.substring(id_end);

        //jezeli wyrazenie nie ma zadnych znakow oprocz liczb to zwroc wynik

        if (!wyrazenie.contains("(") && !wyrazenie.contains(")") && !wyrazenie.contains("\\+") &&
                !wyrazenie.contains("-") && !wyrazenie.contains("*") && !wyrazenie.contains("\\/"))
        {
            return Double.valueOf(wyrazenie);
        }

        else {
            obliczWyrazenie(finalny);
        }
        return 0.0;
    }

    public static void main(String[] args) {
        WyrazenieMatematyczne wm= new WyrazenieMatematyczne();
        System.out.println(wm.obliczWyrazenie("((45-(1*3))+45)"));

    }
}

