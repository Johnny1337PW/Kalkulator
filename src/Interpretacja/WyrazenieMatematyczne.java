package Interpretacja;

public class WyrazenieMatematyczne extends OperacjaMatematycznaZNawiasami {
    //przyjmuje string np "( (4 +3)-2 )*7" i usuwa spacje"
    public static String usunSpacje(String wyrazenie) {
        wyrazenie = wyrazenie.replace(" ","");
        return wyrazenie;
    }

    //przyjmuje string np "[(4+3)-2]*7" i podmienia wszystkie nawiasy na okrągłe"
    public static String podmienNawiasy(String wyrazenie) {
        while(wyrazenie.contains("[")) {
            wyrazenie = wyrazenie.replace("[","(");
        }
        while(wyrazenie.contains("]")) {
            wyrazenie = wyrazenie.replace("]",")");
        }
        while(wyrazenie.contains("{")) {
            wyrazenie = wyrazenie.replace("{","(");
        }
        while(wyrazenie.contains("}")) {
            wyrazenie = wyrazenie.replace("}",")");
        }
        return wyrazenie;
    }

    //przyjmuje string np "((4+3)-2)*7" i oblicza wynik
    public static double obliczWyrazenie(String wyrazenie) {
        if (!wyrazenie.contains("(") && !wyrazenie.contains(")"))
        {
            return interpretujOperacje(wyrazenie);
        }

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

        String dzialanie = wyrazenie.substring(id_start, id_end+1);

        String wynik = String.valueOf(interpretujOperacje(dzialanie.substring(1,dzialanie.length() - 1)));
        String finalny = wyrazenie.substring(0,id_start);
        finalny += wynik;
        finalny += wyrazenie.substring(id_end+1);

        //jezeli wyrazenie nie ma zadnych znakow oprocz liczb to zwroc wynik

        if (finalny.contains("(") || finalny.contains(")") || finalny.contains("+") || finalny.contains("-") || finalny.contains("*") || finalny.contains("/"))
        {
            return obliczWyrazenie(finalny);
        }
        else {
            return Double.parseDouble(finalny);
        }
    }

    public static void main(String[] args) {
        System.out.println(obliczWyrazenie("((45-(1*3))+45)"));
        System.out.println(obliczWyrazenie("2+2"));
    }
}

