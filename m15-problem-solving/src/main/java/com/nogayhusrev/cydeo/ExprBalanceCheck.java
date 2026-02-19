package com.nogayhusrev.cydeo;

import java.util.Stack;

public class ExprBalanceCheck {

    public static void main(String[] args) {
        System.out.println(balanceCheck("(A*C) + ({V-M})"));

    }

    public static boolean balanceCheck(String expr) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < expr.length(); i++) {
            Character ch = expr.charAt(i);

            if (ch != '(' && ch != '[' && ch != '{' && ch != ')' && ch != ']' && ch != '}')
                continue;

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            switch (ch) {
                case ')':
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.pop() != '{')
                        return false;
                    break;
            }


        }

        return stack.isEmpty();
    }
}
