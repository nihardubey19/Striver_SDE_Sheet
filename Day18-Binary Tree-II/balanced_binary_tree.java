    // Time Complexity : O(N)
    // Space Complexity : O(1) + O(h) Recursion stack space 

    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        helper(root, ans);
        return ans[0];
    }
    
    private int helper(TreeNode root, boolean[] ans){
        if(root==null || ans[0]==false) return 0;
        
        int left = helper(root.left, ans);
        int right = helper(root.right, ans);
        
        if(Math.abs(left-right)>1){
            ans[0] = false;
            return 0;
        }
        
        return Math.max(left,right)+1;
    }
