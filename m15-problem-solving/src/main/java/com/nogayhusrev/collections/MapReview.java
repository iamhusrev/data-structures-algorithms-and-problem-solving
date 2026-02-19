package com.nogayhusrev.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapReview {
    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        System.out.println(firstNonRepeatingChar("java"));
        System.out.println(Arrays.toString(twoSum(new int[]{9, 1, 4, 3, 2, 7, 6, 5, 8, 18, 14, 11}, 24)));


    }

    public static int[] twoSum(int[] ints, int target) {
        /*/Brute Force Solution
        for(int i=0;i< ints.length;i++)
            for(int j=1;j<ints.length;j++)
                if (i != j && ints[i] + ints[j]==target)
                    return new int[]{i,j};
        */

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int potentialMatch = target - ints[i];
            if (map.containsKey(potentialMatch))
                return new int[]{i, map.get(potentialMatch)};
            else
                map.put(ints[i], i);
        }


        return null;
    }


    public static Character firstNonRepeatingChar(String str) {

        //create a hash set
        Map<Character, Integer> chars = new HashMap();
        //iterate over the char array and add chars into hashset
        for (Character ch : str.toCharArray()) {
            if (chars.containsKey(ch)) {
                chars.put(ch, chars.get(ch) + 1);
            } else {
                chars.put(ch, 1);
            }
        }

        for (Character ch : str.toCharArray())
            if (chars.get(ch) == 1)
                return ch;

        return null;
    }
}
