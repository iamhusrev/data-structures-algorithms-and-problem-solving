package com.iamhusrev.l5_prefix_sums;

class MinAverageTwoSlice {
    public int solution(int[] A) {
        int N = A.length;
        double minAvg = Double.MAX_VALUE;
        int minStart = 0;

        // N-2'ye kadar dönüyoruz çünkü 3'lü dilim kontrolü yapacağız
        for (int i = 0; i < N - 2; i++) {
            // 2 elemanlı dilim kontrolü
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minStart = i;
            }

            // 3 elemanlı dilim kontrolü
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (avg3 < minAvg) {
                minAvg = avg3;
                minStart = i;
            }
        }

        // Döngü bittikten sonra en sondaki 2'li dilimi unutmamak lazım
        double lastAvg2 = (A[N - 2] + A[N - 1]) / 2.0;
        if (lastAvg2 < minAvg) {
            minAvg = lastAvg2;
            minStart = N - 2;
        }

        return minStart;
    }
}