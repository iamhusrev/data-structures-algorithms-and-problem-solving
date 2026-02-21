package com.iamhusrev.l6_soritng;

import java.util.*;

class Triangle {
    public int solution(int[] A) {
        int N = A.length;
        
        // Üçgen için en az 3 eleman şart
        if (N < 3) return 0;

        // Senin yaptığın gibi sıralıyoruz, bu çok doğru hamle
        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            // Kendi metodunu çağırıyoruz
            // A[i], A[i+1] ve A[i+2] artık p, r, q olarak gidiyor
            if (isTriangle(A[i], A[i+1], A[i+2])) {
                return 1;
            }
            
            // Not: A[i] <= 0 ise A[i] + A[i+1] > A[i+2] olması imkansıza yakındır
            // (çünkü sayılar sıralı). Ama negatif sayılarla vakit kaybetmemek için
            // A[i] > 0 kontrolü de eklenebilir.
//            if (A[i] > 0 && (long) A[i] + A[i + 1] > A[i + 2]) {
//                return 1;
//            }
        }
        return 0;
    }

    // Senin metodun, sadece toplama kısımlarına (long) ekledik
    public boolean isTriangle(int p, int r, int q) {
        // Sayılar 2 milyar civarı olabildiği için toplarken long'a çevirmezsek
        // sonuç negatif çıkar ve "false" döner. Bu da puanını düşürür.
        boolean cond1 = (long) p + r > q;
        boolean cond2 = (long) p + q > r;
        boolean cond3 = (long) q + r > p;

        return cond1 && cond2 && cond3;
    }
}