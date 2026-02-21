package com.iamhusrev.l4_counting_elements;

import java.util.HashSet;
import java.util.Set;

class MissingInteger {
    public static void main(String[] args) {
        var missingInteger = new MissingInteger();
        int[] A = new int[]{
            1, 3, 6, 4, 1, 2
        };
        var result = missingInteger.solution(A);
        System.out.println(result);
    }
    
    public int solution(int[] A) {
        int n = A.length;
        
        // Sadece pozitif sayıları takip etmek için bir boolean dizi kullanıyoruz.
        // Boyutu n + 2 yapıyoruz çünkü en kötü durumda (1,2,3...n) cevap n+1 olur.
        boolean[] seen = new boolean[n + 2];
        
        for (int i = 0; i < n; i++) {
            // Sadece 1 ile n arasındaki sayılarla ilgileniyoruz.
            // n'den büyük bir sayı varsa, aradaki bir sayı mutlaka eksiktir.
            if (A[i] > 0 && A[i] <= n) {
                seen[A[i]] = true;
            }
        }
        
        // 1'den başlayarak ilk "false" olan indeksi dönüyoruz.
        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        
        return 1;
    }
    
    public int solution2(int[] A) {
        int N = 100001;
        Set<Integer> coveredNumbers = new HashSet<>();
        
        for (int i = 0; i < A.length; i++) {
            coveredNumbers.add(A[i]);
        }
        
        
        for (int number = 1; number < N; number++) {
            if (!coveredNumbers.contains(number))
                return number;
            
        }
        
        return 1;
    }
    
}