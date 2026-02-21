package com.iamhusrev.l6_soritng;

import java.util.Arrays;

class MaxProductionOfTriplet {
    public int solution(int[] A) {
        int n = A.length;
        
        // 1. Diziyi küçükten büyüğe sıralıyoruz - O(N log N)
        Arrays.sort(A);
        
        // 2. İhtimal 1: En sağdaki üç sayının çarpımı
        int option1 = A[n - 1] * A[n - 2] * A[n - 3];
        
        // 3. İhtimal 2: En soldaki iki (negatif) sayı ve en sağdaki en büyük sayı
        // Eğer iki büyük negatif sayı varsa çarpımları pozitif ve büyük olur.
        int option2 = A[0] * A[1] * A[n - 1];
        
        // Hangisi büyükse onu dönüyoruz
        return Math.max(option1, option2);
    }
}