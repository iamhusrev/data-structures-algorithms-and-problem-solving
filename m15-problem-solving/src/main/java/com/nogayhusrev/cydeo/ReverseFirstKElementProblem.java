package com.nogayhusrev.cydeo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementProblem {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println("--------------Before-------------");


        reverseFirstK(queue, 4);
        int k = queue.size();
        for (int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }


    }


    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }


        return queue;
    }

}
