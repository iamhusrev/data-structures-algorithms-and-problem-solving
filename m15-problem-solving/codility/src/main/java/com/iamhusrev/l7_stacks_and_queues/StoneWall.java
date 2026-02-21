package com.iamhusrev.l7_stacks_and_queues;

import java.util.Stack;

class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int height : H) {

            // Remove blocks that are taller than current height
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            // If stack is empty or current height is greater,
            // we need a new block
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                blocks++;
            }
            // If equal, continue using the same block (do nothing)
        }

        return blocks;
    }
}