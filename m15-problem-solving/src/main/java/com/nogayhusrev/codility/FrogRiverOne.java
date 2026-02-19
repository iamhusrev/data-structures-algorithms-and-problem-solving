package com.nogayhusrev.codility;

import java.util.HashSet;
import java.util.Set;

class FrogRiverOne {
    public int solution(int X, int[] A) {
        // Hangi konumların dolduğunu benzersiz olarak tutmak için Set kullanıyoruz
        Set<Integer> coveredPositions = new HashSet<>();
        
        for (int time = 0; time < A.length; time++) {
            int position = A[time];
            
            // Sadece X ve altındaki konumlar bizi ilgilendiriyor
            if (position <= X) {
                coveredPositions.add(position);
            }
            
            // Eğer Set'in boyutu X'e ulaştıysa, 1'den X'e her yer dolmuş demektir
            if (coveredPositions.size() == X) {
                return time;
            }
        }
        
        // Yol tamamlanamadıysa
        return -1;
    }
}