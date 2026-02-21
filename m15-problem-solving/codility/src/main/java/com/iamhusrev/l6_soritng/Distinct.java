package com.iamhusrev.l6_soritng;

import java.util.HashSet;
import java.util.Set;

class Distinct {
    public int solution(int[] A) {
        // If the array is empty, there are 0 distinct values
        if (A.length == 0) {
            return 0;
        }

        // Use a HashSet to store unique elements
        Set<Integer> distinctValues = new HashSet<>();
        
        for (int value : A) {
            distinctValues.add(value);
        }
        
        // The size of the set is the count of distinct elements
        return distinctValues.size();
    }
}