package Interpretacja;

import View.Wypisz;

public class OperacjaMatematyczna {
    private String [] mozliweZnaki = {"+", "-", "/", "*"};

    // np. "4/2", "3*3", "1-2", "4.5+1"
    public static Double interpretujOperacje(String wyrazenie) {
        try {
            if(!wyrazenie.contains("+") && !wyrazenie.contains("-") && !wyrazenie.contains("/") && !wyrazenie.contains("*")) {
                return Double.valueOf(wyrazenie);
            }

            if(wyrazenie.contains("+-")) {
                wyrazenie = wyrazenie.replace("+-", "-");
            }

            if(wyrazenie.contains("-+")) {
                wyrazenie = wyrazenie.replace("-+", "-");
            }

            if (wyrazenie.indexOf('-') == -1 && wyrazenie.indexOf('+') == -1 && wyrazenie.indexOf('*') == -1 && wyrazenie.indexOf('/') == -1) {
                Wypisz.wypiszBlad("Wprowadzono niepoprawne wyrażenie");
                return null;
            }
            else if (wyrazenie.indexOf('*') != -1)
            {
                String[] wyrazenieArray = null;
                wyrazenieArray = wyrazenie.split("\\*");
                return Double.parseDouble(wyrazenieArray[0])*Double.parseDouble(wyrazenieArray[1]);
            }
            else if (wyrazenie.indexOf('/') != -1){
                String[] wyrazenieArray = null;
                wyrazenieArray = wyrazenie.split("/");
                return Double.parseDouble(wyrazenieArray[0])/Double.parseDouble(wyrazenieArray[1]);
            }
            else if (wyrazenie.indexOf('+') != -1 && wyrazenie.indexOf('+') != 0)
            {
                String[] wyrazenieArray = null;
                wyrazenieArray = wyrazenie.split("\\+");
                return Double.parseDouble(wyrazenieArray[0])+Double.parseDouble(wyrazenieArray[1]);
            }
            else if (wyrazenie.indexOf('-') != -1 && wyrazenie.indexOf('-') != 0){
                String[] wyrazenieArray = null;
                wyrazenieArray = wyrazenie.split("-");
                return Double.parseDouble(wyrazenieArray[0])-Double.parseDouble(wyrazenieArray[1]);
            }
            else {
                Wypisz.wypiszBlad("Błąd wpisanych znaków");
                return null;
            }
        }
        catch(NumberFormatException nfe) {
            Wypisz.wypiszBlad("Podano liczbę w niepoprawnym formacie");
            return null;
        }
    }

    public static void main(String[] args) {
        String wyrazenie = "487-34";
        String wyrazenie1="483+23";
        String wyrazenie2="999/3";
        String wyrazenie3="3*13";
        String wyrazenie4="5^4";

        System.out.println(interpretujOperacje(wyrazenie));
        System.out.println(interpretujOperacje(wyrazenie1));
        System.out.println(interpretujOperacje(wyrazenie2));
        System.out.println(interpretujOperacje(wyrazenie3));
        System.out.println(interpretujOperacje(wyrazenie4));

        System.out.println(interpretujOperacje("2+2"));
        System.out.println(interpretujOperacje("-1.0*2"));
    }
}
