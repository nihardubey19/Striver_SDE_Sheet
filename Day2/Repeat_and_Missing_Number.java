    // Using Cycle Sort 
    // Time : O(n) 
    
    public int[] repeatedNumber(final int[] nums) {
        int i=0, n=nums.length;        
        while(i<n){            
            if(nums[i]==nums[nums[i]-1]){
                i++;
            }else{
                swap(i, nums[i]-1, nums);
            }
        }
        
        for(int j=0; j<n; j++){
            if(j!=nums[j]-1)
                return new int[]{nums[j], j+1};
        }
        
        return new int[]{};
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
