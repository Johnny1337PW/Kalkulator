package Interpretacja;

public class OperacjaMatematyczna {
    private String [] mozliweZnaki = {"+", "-", "/", "*"};

    // np. "4/2", "3*3", "1-2", "4.5+1"
    public Double interpretujOperacje(String wyrazenie) {

        if (wyrazenie.indexOf('-') == -1 && wyrazenie.indexOf('+') == -1 && wyrazenie.indexOf('*') == -1 && wyrazenie.indexOf('/') == -1) {
            System.out.println("Wprowadzono niepoprawne wyrażenie");
            return 0.0;
        }
        else if (wyrazenie.indexOf('-') != -1){
            String[] wyrazenieArray = null;
            wyrazenieArray = wyrazenie.split("-");
            double wynik = Double.parseDouble(wyrazenieArray[0])-Double.parseDouble(wyrazenieArray[1]);
            return wynik;
        }

        else if (wyrazenie.indexOf('+') != -1)
        {
            String[] wyrazenieArray = null;
            wyrazenieArray = wyrazenie.split("\\+");
            double wynik = Double.parseDouble(wyrazenieArray[0])+Double.parseDouble(wyrazenieArray[1]);
            return wynik;
        }

        else if (wyrazenie.indexOf('*') != -1)
        {
            String[] wyrazenieArray = null;
            wyrazenieArray = wyrazenie.split("\\*");
            double wynik = Double.parseDouble(wyrazenieArray[0])*Double.parseDouble(wyrazenieArray[1]);
            return wynik;
        }


        else {
            String[] wyrazenieArray = null;
            wyrazenieArray = wyrazenie.split("/");
            double wynik = Double.parseDouble(wyrazenieArray[0])/Double.parseDouble(wyrazenieArray[1]);
            return wynik;
        }
    }

    public static void main(String[] args) {
        OperacjaMatematyczna om = new OperacjaMatematyczna();
        String wyrazenie = "487-34";
        String wyrazenie1="483+23";
        String wyrazenie2="999/3";
        String wyrazenie3="3*13";
        String wyrazenie4="5^4";

        System.out.println(om.interpretujOperacje(wyrazenie));
        System.out.println(om.interpretujOperacje(wyrazenie1));
        System.out.println(om.interpretujOperacje(wyrazenie2));
        System.out.println(om.interpretujOperacje(wyrazenie3));
        System.out.println(om.interpretujOperacje(wyrazenie4));
    }
}
