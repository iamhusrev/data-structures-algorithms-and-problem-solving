package com.iamhusrev.l5_prefix_sums;

class GnomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        
        // Her nükleotid için prefix sum tabloları (N+1 boyutu kolaylık sağlar)
        int[][] counts = new int[4][N + 1];

        for (int i = 0; i < N; i++) {
            int a = 0, c = 0, g = 0, t = 0;
            char letter = S.charAt(i);
            
            if (letter == 'A') a = 1;
            else if (letter == 'C') c = 1;
            else if (letter == 'G') g = 1;
            else if (letter == 'T') t = 1;

            // Önceki toplamın üzerine mevcut olanı ekle
            counts[0][i + 1] = counts[0][i] + a;
            counts[1][i + 1] = counts[1][i] + c;
            counts[2][i + 1] = counts[2][i] + g;
            counts[3][i + 1] = counts[3][i] + t;
        }

        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1; // Prefix sum indis kayması nedeniyle +1

            // En küçükten başlayarak kontrol et
            if (counts[0][end] - counts[0][start] > 0) {
                result[k] = 1;
            } else if (counts[1][end] - counts[1][start] > 0) {
                result[k] = 2;
            } else if (counts[2][end] - counts[2][start] > 0) {
                result[k] = 3;
            } else {
                result[k] = 4;
            }
        }

        return result;
    }
}