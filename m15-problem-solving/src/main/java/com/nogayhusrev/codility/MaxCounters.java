package com.nogayhusrev.codility;

class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMax = 0; // O ana kadarki en yüksek skor
        int lastMax = 0;    // En son "hepsini max yap" denildiğindeki seviye

        for (int i = 0; i < A.length; i++) {
            int operation = A[i];

            if (operation >= 1 && operation <= N) {
                int index = operation - 1;

                // Tembel güncelleme: Sayacı en son max seviyesine çek
                if (counters[index] < lastMax) {
                    counters[index] = lastMax;
                }

                // 1 arttır ve yeni zirveyi takip et
                counters[index]++;
                if (counters[index] > currentMax) {
                    currentMax = counters[index];
                }
            } 
            else if (operation == N + 1) {
                // Hepsini güncellemek yerine sadece çıtayı (lastMax) yükselt
                lastMax = currentMax;
            }
        }

        // Son kontrol: lastMax altında kalanları güncelle
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastMax) {
                counters[i] = lastMax;
            }
        }

        return counters;
    }
}

