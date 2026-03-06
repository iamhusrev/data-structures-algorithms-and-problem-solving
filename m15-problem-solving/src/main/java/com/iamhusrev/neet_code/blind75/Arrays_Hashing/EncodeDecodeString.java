package com.iamhusrev.neet_code.blind75.Arrays_Hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    // Encode: "length#string" format for each string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode: read length until '#', then read that many chars
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Find the '#' separator
            int j = i;
            while (s.charAt(j) != '#') j++;

            // Parse the length
            int len = Integer.parseInt(s.substring(i, j));

            // Extract the string
            result.add(s.substring(j + 1, j + 1 + len));

            // Move pointer to next encoded string
            i = j + 1 + len;
        }

        return result;
    }
}