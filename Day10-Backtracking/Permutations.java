    // Time Complexity : O(N! * N)
    // Space Complexity : O(N)
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];    
        }
        
        helper(0, arr, new LinkedList<>(), ans);
        return ans;
    }
    
    private void helper(int idx, Integer[] nums, LinkedList<Integer> ds, List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(Arrays.asList(nums)));
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            swap(i, idx, nums);
            helper(idx+1, nums, ds, ans);
            swap(i, idx, nums);
        }
    }
    
    private void swap(int i, int j, Integer[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
