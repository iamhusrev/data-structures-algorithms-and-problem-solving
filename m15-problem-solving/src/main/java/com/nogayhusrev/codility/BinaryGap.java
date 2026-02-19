package com.nogayhusrev.codility;

/**
 https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */

class BinaryGap {
    public int solution(int N) {
        // Implement your solution here
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;
        
        while (N > 0) {
            if ((N & 1) == 1) {
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                currentGap = 0;
                counting = true;
            } else {
                if (counting) {
                    currentGap++;
                }
            }
            
            N = N >> 1;
            
        }
        
        return maxGap;
    }
}
