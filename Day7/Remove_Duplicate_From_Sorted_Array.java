    //1. using Time Complexity : O(log(n)) for treeset
    // and adding n elements into treeset -> total time : nlog(n)
    // and Space Complexity : O(n) for extra space
    
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int x: nums){
            set.add(x);
        }
        // Arrays.fill(nums, 0);
        int idx=0, n = nums.length;
        for(int x: set){
            nums[idx++] = x;
        }
        return idx;
    }

// --------------------------------------------------------

    // using Time Complexity : O(n)
    // and Space Complexity : O(1)
    public int removeDuplicates(int[] nums) {
        int idx=1, n=nums.length;
        int prev=nums[0];
        for(int i=1; i<n; i++){
            if(prev!=nums[i]){
                nums[idx++] = nums[i];
                prev = nums[i];
            }
        }
        return idx;
    }
