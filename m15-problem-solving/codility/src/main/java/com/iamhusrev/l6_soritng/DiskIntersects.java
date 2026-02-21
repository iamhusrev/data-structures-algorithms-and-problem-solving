package com.iamhusrev.l6_soritng;

import java.util.Arrays;

class DiskIntersects {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) return 0;

        long[] starts = new long[N];
        long[] ends = new long[N];

        for (int i = 0; i < N; i++) {
            starts[i] = (long) i - A[i];
            ends[i] = (long) i + A[i];
        }

        // Başlangıç ve bitiş noktalarını ayrı ayrı sıralıyoruz
        Arrays.sort(starts);
        Arrays.sort(ends);

        int activeDiscs = 0;
        int intersections = 0;
        int j = 0; // Bitiş noktalarını takip eden işaretçi

        for (int i = 0; i < N; i++) {
            // Mevcut disk başlamadan önce kaç tane disk bitti?
            while (j < N && ends[j] < starts[i]) {
                activeDiscs--;
                j++;
            }

            // Yeni bir disk başlıyor. 
            // Bu disk, halihazırda "aktif" olan tüm disklerle kesişir.
            intersections += activeDiscs;
            activeDiscs++;

            // Sınır kontrolü (10 milyon)
            if (intersections > 10000000) {
                return -1;
            }
        }

        return intersections;
    }
}