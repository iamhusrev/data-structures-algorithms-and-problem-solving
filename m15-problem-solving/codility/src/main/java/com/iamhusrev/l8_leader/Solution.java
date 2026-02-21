package com.iamhusrev.l8_leader;

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3,4,3,2,3,-1,3,3}));
    }
    public int solution(int[] A) {
        // Implement your solution here

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : A){
            map.put(n, map.getOrDefault(n,0) +1);
        }

        int pivot = A.length / 2;
        int dominator= -1;
        
        for(int key : map.keySet()){
            if(map.getOrDefault(key,0) > pivot)
                dominator=key;
        }
        
        for(int i=0; i<A.length; i++)
            if(A[i] == dominator)
                dominator=i;
        
        
        
        return dominator;
    }
}