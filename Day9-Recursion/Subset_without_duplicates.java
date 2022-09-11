   // Time Complexity : O(2^n)
   // Space Complexity : O(2^n * k), Auxilary Space O(n) for recursion

    private List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new LinkedList<>());
        return ans;
    }
    
    private void helper(int idx, int[] nums, LinkedList<Integer> temp){
        if(idx==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[idx]);
        helper(idx+1, nums, temp);
        int prev = nums[idx];
        while(idx<nums.length && prev==nums[idx]){
            idx++;
        }
        temp.removeLast();
        helper(idx, nums, temp);
    }
