package com.nogayhusrev.codility;

class PermutationCheck {
    public int solution(int[] A) {
        int N = A.length;
        
        // Permütasyon takibi için bir boolean dizi oluşturuyoruz
        // Boyutu N + 1 yapıyoruz çünkü sayılar 1'den başlıyor
        boolean[] seen = new boolean[N + 1];
        
        for (int i = 0; i < N; i++) {
            int current = A[i];
            
            // Şart 1: Sayı 1 ile N arasında mı? 
            // Eğer dizide N'den büyük bir sayı varsa permütasyon olamaz.
            if (current < 1 || current > N) {
                return 0;
            }
            
            // Şart 2: Bu sayıyı daha önce gördük mü?
            // Eğer aynı sayıdan iki tane varsa permütasyon bozulur.
            if (seen[current]) {
                return 0;
            }
            
            // Sayıyı gördük diye işaretle
            seen[current] = true;
        }
        
        // Eğer buraya kadar geldiysek, N tane farklı sayı 1..N aralığında demektir.
        return 1;
    }
}