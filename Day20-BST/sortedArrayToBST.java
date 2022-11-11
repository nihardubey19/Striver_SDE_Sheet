    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }

    private TreeNode helper(int low, int high, int[] nums){
        if(low>high) return null;
        if(low==high) return new TreeNode(nums[low]);
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(low, mid-1, nums);
        root.right = helper(mid+1, high, nums);
        return root;
    }
