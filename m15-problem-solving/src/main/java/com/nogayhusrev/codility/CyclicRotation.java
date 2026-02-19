package com.nogayhusrev.codility;

class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        
        // 1. Durum: Dizi boşsa veya sadece 1 eleman varsa döndürmeye gerek yok.
        if (N <= 1) {
            return A;
        }
        
        // 2. Durum: Gereksiz turları ele (K, N'den büyükse).
        K = K % N;
        
        // Eğer K tam olarak N'in katıysa dizi değişmez.
        if (K == 0) {
            return A;
        }
        
        // 3. Durum: Yeni diziyi oluştur.
        int[] result = new int[N];
        
        for (int i = 0; i < N; i++) {
            // Her elemanın yeni pozisyonunu hesapla
            int newIndex = (i + K) % N;
            result[newIndex] = A[i];
        }
        
        return result;
    }
}