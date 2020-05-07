package Interpretacja;

import java.util.Stack;

public class OperacjaMatematycznaZNawiasami extends OperacjaMatematyczna {
    private String [] nawiasy= {"(", ")", "{", "}", "[", "]"};

    public String pobierzNawiasy(String operacjaZNawiasami) {
        StringBuilder sameNawiasy = new StringBuilder();

        for(int i = 0; i < operacjaZNawiasami.length(); i++){
            for (String s : this.nawiasy) {
                if (operacjaZNawiasami.charAt(i) == s.charAt(0)) {
                    sameNawiasy.append(operacjaZNawiasami.charAt(i));
                }
            }
        }

        return sameNawiasy.toString();
    }

    public boolean sprawdzNawiasy(String operacjaZNawiasami) {
        String sameNawiasy = pobierzNawiasy(operacjaZNawiasami);
        Stack<Character> stack = new Stack<>();
        char c, top;
        for(int i = 0; i < sameNawiasy.length(); i++){
            c = sameNawiasy.charAt(i);
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty())
                    return false;
                top = stack.pop();
                if(c == ')' && top != '(')
                    return false;
                if(c == '}' && top != '{')
                    return false;
                if(c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        OperacjaMatematycznaZNawiasami op = new OperacjaMatematycznaZNawiasami();

        String wyrazeniePoprawne = "[4+2*{2-1}+8/(3-4.56)]";
        String wyrazenieBledne = "[4+2*[2-1}+8/(3-4.56)]";

        System.out.println(op.sprawdzNawiasy(wyrazeniePoprawne));
        System.out.println(op.sprawdzNawiasy(wyrazenieBledne));
    }
}
