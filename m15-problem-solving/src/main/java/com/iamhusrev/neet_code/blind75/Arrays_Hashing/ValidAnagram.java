package com.iamhusrev.neet_code.blind75.Arrays_Hashing;

import java.util.HashMap;
import java.util.Map;

/*
    242. Valid Anagram
    https://leetcode.com/problems/valid-anagram/

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
    1 <= s.length, t.length <= 5 * 10^4
    s and t consist of lowercase English letters.
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        int[] chars = new int[26];
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            sMap.put(sc, 1 + sMap.getOrDefault(sc, 0));
            tMap.put(tc, 1 + tMap.getOrDefault(tc, 0));
        }
        
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            
            if (tMap.getOrDefault(key, 0) != value)
                return false;
        }
        
        
        return true;
        
        
    }
}
