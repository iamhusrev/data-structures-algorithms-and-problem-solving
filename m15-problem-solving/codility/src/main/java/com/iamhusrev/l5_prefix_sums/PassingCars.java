package com.iamhusrev.l5_prefix_sums;

class PassingCars {
    public static void main(String[] args) {
        var passingCars = new PassingCars();
        int[] A = new int[]{
            0, 1, 0, 1, 1
        };
        var result = passingCars.solution(A);
        System.out.println(result);
    }
    public int solution(int[] A) {
        long passingCars = 0; // Toplam 1 milyarı geçebileceği için long kullanmak güvenlidir
        int eastCars = 0;

        for (int car : A) {
            if (car == 0) {
                // Doğuya giden bir araba gördük, biriktirelim
                eastCars++;
            } else {
                // Batıya giden bir araba gördük. 
                // Bu araba, kendisinden önce yola çıkan tüm doğu arabalarıyla karşılaşır.
                passingCars += eastCars;
            }
        }

        // Sınır kontrolü (1,000,000,000)
        if (passingCars > 1000000000) {
            return -1;
        }

        return (int) passingCars;
    }
}