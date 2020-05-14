package Memory;

import java.lang.reflect.Field;

public class Pamięć {
    //Stałe matematyczne
    private static double pi = 3.14159265359; // liczba pi
    private static double ee = 2.71828182846; // liczba eulera
    private static double eu = 0.57721566490; // stała eulera
    private static double fi = 1.61803398874; // złoty podział
    private static double ch = 2.6854520; // stała Chinczyna
    private static double ap = 1.20205690315; // stała Apery'ego
    private static double mt = 0.2614972128; // stała mertensa
    private static double ct = 0.915965594177; // stała Catalana
    private static double si = 2.58498175957; // stała Sierpińskiego
    private static double ga = 0.83462684167; // stała Gaussa
    //Stałe fizyczne
    private static double cl = 299792458;//predkosc swiatla
    private static double un = 1.00728;//masa unitu
    private static double nr = 8.314459848;//stala gazowa
    private static double gz = 9.81;//przyspieszenie ziemskie
    private static double hu = 77;//stała Hubble’a
    private static double om = 0.0224136;//Objętość molowa gazu w warunkach normalnych

    public static double getConstant(String constant) {
        Pamięć p = new Pamięć();
        try {
            Field field = Pamięć.class.getDeclaredField(constant);
            return field.getDouble(p);
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Brak stałej w bazie");
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(Pamięć.getConstant("pi"));
        System.out.println(Pamięć.getConstant("cl"));
        System.out.println(Pamięć.getConstant("op"));
        System.out.println(Pamięć.getConstant("ap"));
    }
}
