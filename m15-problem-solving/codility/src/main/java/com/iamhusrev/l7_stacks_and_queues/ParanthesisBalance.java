package com.iamhusrev.l7_stacks_and_queues;

class ParanthesisBalance {
    public int solution(String S) {
        // N = 1,000,000 olduğu için O(N) sürede çözmeliyiz
        int counter = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                counter++;
            } else {
                // Eğer kapatacak bir parantez yokken ')' geldiyse dengesizdir
                counter--;
                if (counter < 0) {
                    return 0;
                }
            }
        }

        // En son tüm açılanlar kapanmış mı? (Sayaç 0 mı?)
        return (counter == 0) ? 1 : 0;
    }
}