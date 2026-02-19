package com.nogayhusrev.codility;

class PermMissingElem {
    public int solution(int[] A) {
        // N, dizinin uzunluğudur. Eksik elemanla birlikte toplam N+1 sayı olmalı.
        long n = A.length;
        
        // 1'den N+1'e kadar olan sayıların toplamı
        // Not: int aşımı (overflow) olmasın diye 'long' kullanıyoruz.
        long totalExpectedSum = (n + 1) * (n + 2) / 2;
        
        long actualSum = 0;
        for (int number : A) {
            actualSum += number;
        }
        
        // Aradaki fark kayıp elemandır
        return (int) (totalExpectedSum - actualSum);
    }
}