package com.iamhusrev;

class MinDifference {
    public int solution(int[] A) {
        long totalSum = 0;
        for (int number : A) {
            totalSum += number;
        }
        
        long leftSum = 0;
        long minDifference = Long.MAX_VALUE;
        
        // P noktası diziyi ikiye bölmeli, bu yüzden son elemana kadar gitmiyoruz (N-1)
        for (int p = 0; p < A.length - 1; p++) {
            leftSum += A[p];
            long rightSum = totalSum - leftSum;
            long currentDifference = Math.abs(leftSum - rightSum);
            
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
            }
        }
        
        return (int) minDifference;
    }
}