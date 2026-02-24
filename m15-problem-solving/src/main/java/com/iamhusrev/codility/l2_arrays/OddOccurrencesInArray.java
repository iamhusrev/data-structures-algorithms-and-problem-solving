package com.iamhusrev.codility.l2_arrays;

import java.util.HashMap;
import java.util.Map;

class OddOccurrencesInArray {
    
    /*
    🧠 Efsanevi Çözüm: XOR Operatörü
XOR işleminin (^) mülakatlarda hayat kurtaran 3 kuralı vardır:

Bir sayıyı kendisiyle XOR'larsan 0 olur: x ^ x = 0

Bir sayıyı 0 ile XOR'larsan kendisi olur: x ^ 0 = x

İşlem sırası önemli değildir: a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b

Bu kurallara göre; dizideki tüm sayıları birbirleriyle XOR'larsan, eşleşen (çift sayıda olan) tüm sayılar birbirini yok eder (0 olur).
 Geriye sadece tek kalan (unpaired) sayı kalır!
     */
    public int solution1(int[] A) {
        int result = 0;
        
        for (int number : A) {
            // XOR işlemi: Çiftler birbirini sıfırlayacak
            result = result ^ number;
        }
        
        return result;
    }
    
    
    public int solution(int[] A) {
        // Implement your solution here
        
        if (A.length <= 1) {
            return A[0];
        }
        
        Map<Integer, Integer> pairs = new HashMap<>();
        
        
        for (int i = 0; i < A.length; i++) {
            if (pairs.containsKey(A[i])) {
                pairs.put(A[i], pairs.get(A[i]) + 1);
            } else {
                pairs.put(A[i], 1);
            }
        }
        
        for (Integer key : pairs.keySet()) {
            if (pairs.get(key) == 1)
                return key;
        }
        
        
        return -1;
        
    }
}