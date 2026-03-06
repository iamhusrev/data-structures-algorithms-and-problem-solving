package com.iamhusrev.neet_code.blind75.Arrays_Hashing;

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] result = new int[n];
        
        prefix[0] = 1;
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        postfix[n - 1] = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        
        return result;
        
    }
    
    public int[] productExceptSelfOptimal(int[] nums) {
        
        
        int n = nums.length;
        int[] result = new int[n];
        
        int prefix = 1;
        
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        
        int postfix = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        
        return result;
        
    }
}
