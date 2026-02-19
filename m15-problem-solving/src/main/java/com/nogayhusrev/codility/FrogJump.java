package com.nogayhusrev.codility;

class FrogJump {
    public int solution(int X, int Y, int D) {
        // 1. Gidilmesi gereken toplam net mesafeyi bul
        int distanceToCover = Y - X;

        // 2. Eğer zaten hedefteyse 0 zıplayış
        if (distanceToCover <= 0) {
            return 0;
        }

        // 3. Tam zıplayış sayısını bul
        int jumps = distanceToCover / D;

        // 4. Eğer kalan yol varsa (tam bölünmediyse), bir zıplayış daha ekle
        if (distanceToCover % D != 0) {
            jumps++;
        }

        return jumps;
    }
}