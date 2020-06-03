package Interpretacja;

import Memory.Pamięć;
import View.Wypisz;

public class InterpretujTest {
    private static int testId = 0;

    public static void testRówności(String input, Double value){
        testId += 1;
        System.out.print("Test nr" + testId + " - result: ");
        Double inp = Interpreter.interpretuj(input);
        if (inp.equals(value)) {
            System.out.print("good\n");
        }
        else {
            System.out.print("fail!!!\n");
        }
    }

    public static void main(String[] args) {

        Wypisz.setCzyTest(true);

        testRówności("2+2", 4d); // 1
        testRówności("4-2", 2d); // 2
        testRówności("3/2", 1.5); // 3
        testRówności("2*2", 4d); // 4
        testRówności("(2+2)", 4d); // 5
        testRówności("((4-2))", 2d); // 6
        testRówności("(((2/2)))", 1d); // 7
        testRówności("((((2*2))))", 4d); // 8
        testRówności("(2+2) * 2", 8d); // 9
        testRówności("((4-2)) / 2", 1d); // 10
        testRówności("(((2/2))) - 1", 0d); // 11
        testRówności("((((2*2)))) + 7", 11d); // 12
        testRówności("[2+2]", 4d); // 13
        testRówności("[{4-2}]", 2d); // 14
        testRówności("([{2/2}])", 1d); // 15
        testRówności("{{[[2*2]]}}", 4d); // 16
        testRówności("[2+2] * 2", 8d); // 17
        testRówności("[{4-2}] / 2", 1d); // 18
        testRówności("([{2/2}]) - 1", 0d); // 19
        testRówności("{{[[2*2]]}} + 7", 11d); // 20
        testRówności("@pi@", Pamięć.getConstant("pi")); // 21
        testRówności("@ee@", Pamięć.getConstant("ee")); // 22
        testRówności("@pi@ + @ee@", Pamięć.getConstant("pi") + Pamięć.getConstant("ee")); // 23
        testRówności("@gz@ * 2", Pamięć.getConstant("gz") * 2); // 24
        testRówności("([2+2] * 2) + 1", 9d); // 25
        testRówności("([{4-2}] / 2) - 9", -8d); // 26
        testRówności("(([{2/2}]) - 2) * 2", -2d); // 27
        testRówności("({{[[2*2]]}} + 8) / 3", 4d); // 28
        testRówności("((3*1) + (17/2))", 11.5); // 29
        testRówności("((4 * -1.5) + (27 / 2)) * 14", 105d); // 30
        testRówności("3*3",9d); //31
        testRówności("(5*12)+(3/2)", 61.5); //32
        testRówności("5+(12*2)", 29d); //33
        testRówności("{15*2}+159", 189d); //34
        testRówności("(1*2)*3", 6d); //35
        testRówności("8+18", 26d); //36
        testRówności("[({21*1}+6)-5]", 22d); //37
        testRówności("12*2", 24d); //38
        testRówności("(2*3)+8", 14d); //39
        testRówności("(7*3)*3", 63d); //40
        testRówności("(3-2)*8", 8d); //41
        testRówności("[1+4]*5", 25d); //42
        testRówności("(9*0)+0", 0d); //43
        testRówności("15*0", 0d); //44
        testRówności("(7+7)*2", 28d); //45
        testRówności("(12*2)+2", 26d); //46
        testRówności("3+@pi@", 3+Pamięć.getConstant("pi")); //47
        testRówności("7*7", 49d); //48
        testRówności("(18+(35*2))-5", 83d); //49
        testRówności("15*(2+1)", 45d); //50
        testRówności("(5+4)*2", 18d); //51
        testRówności("((6*12)+5)", 77d); //52
        testRówności("((4*7) + 4)*3", 96d); // 53
        testRówności("@ee@*@pi@", Pamięć.getConstant("ee")*Pamięć.getConstant("pi")); //54
        testRówności("(([{8/2}]) - 2) * 2", 4d); //55
        testRówności("((2*7)-2)*2", 24d); //56
        testRówności("(((20/2))) - 1", 9d); //57
        testRówności("3 - 1", 2d); //58
        testRówności("(34-31)*(34-33)", 3d); //59
        testRówności("(25-21)*(3*3)", 36d); //60
        testRówności("(2*3)*(3-3)", 0d); //61
        testRówności("((2/2)*(3-2))", 1d); //62
        testRówności("(25-21)*(3*3)", 36d); //63
        testRówności("(2*3)*(3-3)", 0d); //64
        testRówności("3-5", -2d); //65
        testRówności("(5+2)-9", -2d); //66
        testRówności("(12*2)-(5*5)", -1d); //67
        testRówności("5-(12/2)", -1d); //68
        testRówności("(125*5)-((1000*5)/2)", -1875d); //69
        testRówności("((77)-122)*2", -90d); //70
        testRówności("(((3*2)*3)-(4*2))-((18*9)+111111)", -111263d); //71
        testRówności("!(src/test.txt)", 6d); //72
        testRówności("!(src/dzialanie.txt)", 25d); //73
        testRówności("!(src/dzialanie.txt", 0d); //74
        testRówności("!(src/dzialnie.txt)", 0d); //75
    }
}
