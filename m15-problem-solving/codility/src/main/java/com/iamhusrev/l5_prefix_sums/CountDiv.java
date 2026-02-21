package com.iamhusrev.l5_prefix_sums;

class CountDiv {
    public static void main(String[] args) {
        var countDiv = new CountDiv();
        int A = 6;
        int B = 11;
        int K = 2;
        var result = countDiv.solution(A, B, K);
        System.out.println(result);
    }
    
    public int solution(int A, int B, int K) {
        // 0'dan B'ye kadar K'ya bölünenlerin sayısı
        int countB = B / K;
        
        // 0'dan A-1'e kadar K'ya bölünenlerin sayısı
        int countA = (A > 0) ? (A - 1) / K : -1;
        
        // Aradaki farkı döndür
        // Eğer A = 0 ise, 0/K tam bölünür olduğu için +1 eklenmiş olur
        return countB - countA;
    }
}