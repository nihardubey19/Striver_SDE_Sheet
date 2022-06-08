// Using Time-> O(n^2)
// Space->O(1)

   public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }


// Using Kadane's Algorithm
// Time-> O(1)
// Space-> O(1)

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE, currSum=0;
        for(int i=0; i<n; i++){
            currSum+=nums[i];
            if(maxSum<currSum)
                maxSum = currSum;
            if(currSum<0)
                currSum = 0;
        }
        return maxSum;
    }


