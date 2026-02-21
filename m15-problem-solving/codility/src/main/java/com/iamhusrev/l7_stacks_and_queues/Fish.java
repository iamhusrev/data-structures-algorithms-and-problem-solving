package com.iamhusrev.l7_stacks_and_queues;

import java.util.Stack;

class Fish {
    public int solution(int[] A, int[] B) {

        Stack<Integer> downstream = new Stack<>();
        int alive = 0;

        for (int i = 0; i < A.length; i++) {

            if (B[i] == 1) {
                // Downstream fish
                downstream.push(A[i]);
            } else {
                // Upstream fish
                boolean eaten = false;

                while (!downstream.isEmpty()) {
                    if (downstream.peek() > A[i]) {
                        // Upstream fish dies
                        eaten = true;
                        break;
                    } else {
                        // Downstream fish dies
                        downstream.pop();
                    }
                }

                if (!eaten) {
                    alive++;
                }
            }
        }

        return alive + downstream.size();
    }
}