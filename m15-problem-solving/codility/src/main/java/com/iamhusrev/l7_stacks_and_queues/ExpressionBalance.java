package com.iamhusrev.l7_stacks_and_queues;

import java.util.Stack;

class ExpressionBalance {
    
    public static void main(String[] args) {
        ExpressionBalance eb = new ExpressionBalance();
        System.out.println(eb.solution("([)()]"));
    }
    
    
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        
        
        for (char c : S.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return 0;
                
                char lastOpen = stack.pop();
                
                if ((c == ')' && lastOpen != '(') ||
                    (c == ']' && lastOpen != '[') ||
                    (c == '}' && lastOpen != '{')) {
                    return 0;
                }
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
    
}