package Interpretacja;

import Memory.Pamięć;

public class InterpretujTest {
    private static int testId = 0;

    public static void testRówności(String input, double value){
        testId += 1;
        System.out.print("Test nr." + testId + " - result: ");
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
    }
}
