package com.iamhusrev.neet_code.blind75.Arrays_Hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
    347. Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/

    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Constraints:
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.
 */
class TopKFrequent {
    
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent.topKFrequent(nums, k);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        // step 1: count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        
        // step 2: bucket sort — index = frequency, value = list of numbers
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        // step 3: collect top k from highest frequency to lowest
        int[] result = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] == null) continue;
            for (int n : bucket[i]) {
                result[idx++] = n;
                if (idx == k) break;
            }
        }
        
        return result;
    }
    
    public int[] topKFrequentWithHeap(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Min-heap of size k
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            Comparator.comparingInt(freqMap::get)
        );
        
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        
        for (int key : freqMap.keySet()) {
            heap.offer(key);
            if (heap.size() > k) heap.poll(); // remove least frequent
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}