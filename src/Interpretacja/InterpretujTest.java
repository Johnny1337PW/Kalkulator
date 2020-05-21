package Interpretacja;

import Memory.Pamięć;

public class InterpretujTest {
    private static int testId = 0;

    public static void testRówności(String input, double value){
        testId += 1;
        System.out.print("Test nr" + testId + " - result: ");
        if (Interpreter.interpretuj(input) == value) {
            System.out.print("good\n");
        }
        else {
            System.out.print("fail!!!\n");
        }
    }

    public static void main(String[] args) {
        testRówności("2+2", 4); // 1
        testRówności("4-2", 2); // 2
        testRówności("3/2", 1.5); // 3
        testRówności("2*2", 4); // 4
        testRówności("(2+2)", 4); // 5
        testRówności("((4-2))", 2); // 6
        testRówności("(((2/2)))", 1); // 7
        testRówności("((((2*2))))", 4); // 8
        testRówności("(2+2) * 2", 8); // 9
        testRówności("((4-2)) / 2", 1); // 10
        testRówności("(((2/2))) - 1", 0); // 11
        testRówności("((((2*2)))) + 7", 11); // 12
        testRówności("[2+2]", 4); // 13
        testRówności("[{4-2}]", 2); // 14
        testRówności("([{2/2}])", 1); // 15
        testRówności("{{[[2*2]]}}", 4); // 16
        testRówności("[2+2] * 2", 8); // 17
        testRówności("[{4-2}] / 2", 1); // 18
        testRówności("([{2/2}]) - 1", 0); // 19
        testRówności("{{[[2*2]]}} + 7", 11); // 20
        testRówności("@pi@", Pamięć.getConstant("pi")); // 21
        testRówności("@ee@", Pamięć.getConstant("ee")); // 22
        testRówności("@pi@ + @ee@", Pamięć.getConstant("pi") + Pamięć.getConstant("ee")); // 23
        testRówności("@gz@ * 2", Pamięć.getConstant("gz") * 2); // 24
        testRówności("([2+2] * 2) + 1", 9); // 25
        testRówności("([{4-2}] / 2) - 9", -8); // 26
        testRówności("(([{2/2}]) - 2) * 2", -2); // 27
        testRówności("({{[[2*2]]}} + 8) / 3", 4); // 28
        testRówności("((3*1) + (17/2))", 11.5); // 29
        testRówności("((4 * -1.5) + (27 / 2)) * 14", 105); // 30
        testRówności("3*3",9); //31
        testRówności("(5*12)+(3/2)", 61.5); //32
        testRówności("5+(12*2)", 29); //33
        testRówności("{15*2}+159", 189); //34
        testRówności("(1*2)*3", 6); //35
        testRówności("8+18", 26); //36
        testRówności("[({21*1}+6)-5]", 22); //37
        testRówności("12*2", 24); //38
        testRówności("(2*3)+8", 14); //39
        testRówności("(7*3)*3", 63); //40
        testRówności("(3-2)*8", 8); //41
        testRówności("[1+4]*5", 25); //42
        testRówności("(9*0)+0", 0); //43
        testRówności("15*0", 0); //44
        testRówności("(7+7)*2", 28); //45
        testRówności("(12*2)+2", 26); //46
        testRówności("3+@pi@", 3+Pamięć.getConstant("pi")); //47
        testRówności("7*7", 49); //48
        testRówności("(18+(35*2))-5", 83); //49
        testRówności("15*(2+1)", 45); //50
        testRówności("(5+4)*2", 18); //51
        testRówności("((6*12)+5)", 77); //52
        testRówności("((4*7) + 4)*3", 96); // 53
        testRówności("@ee@*@pi@", Pamięć.getConstant("ee")*Pamięć.getConstant("pi")); //54
        testRówności("(([{8/2}]) - 2) * 2", 4); //55
        testRówności("((2*7)-2)*2", 24); //56
        testRówności("(((20/2))) - 1", 9); //57
        testRówności("3 - 1", 2); //58
        testRówności("(34-31)*(34-33)", 3); //59
        testRówności("(25-21)*(3*3)", 36); //60
        testRówności("(2*3)*(3-3)", 0); //61
        testRówności("((2/2)*(3-2))", 1); //62
        testRówności("(25-21)*(3*3)", 36); //63
        testRówności("(2*3)*(3-3)", 0); //64
        testRówności("3-5", -2); //65
        testRówności("(5+2)-9", -2); //66
        testRówności("(12*2)-(5*5)", -1); //67
        testRówności("5-(12/2)", -1); //68
        testRówności("(125*5)-((1000*5)/2)", -1875); //69
        testRówności("((77)-122)*2", -90); //70
        testRówności("(((3*2)*3)-(4*2))-((18*9)+111111)", -111263); //71

    }
}
