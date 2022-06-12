    //1.  Using Cycle Sort
    // Time: O(n) and Space : O(1)
    public int findDuplicate(int[] nums) {
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
                return nums[j];
        }
        
        return -1;
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ---------------------------------------------- 
    //2.  Using Time : O(n) and Space : O(n)

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x: nums){
            if(!set.contains(x))
                set.add(x);
            else
                return x;
        }
        return -1;
    }

    // -------------------------------------
    //3.  Using O(nlogn)

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if(prev==nums[i])
                return nums[i];
            prev = nums[i];
        }
        return -1;
    }

