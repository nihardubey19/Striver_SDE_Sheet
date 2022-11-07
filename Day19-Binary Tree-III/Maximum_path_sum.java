    // Using Recusion
    // Time Complexity : O(n)
    // Space Complexity : O(1), O(h) -> stack space of height of tree


    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    
    private int solve(TreeNode root){
        // Base Condition
        if(root==null)
            return 0;
        
        // Hypothesis
        int l = solve(root.left);
        int r = solve(root.right);
        
        // induction
        int temp = Math.max((Math.max(l,r)+root.val), root.val);
        int ans = Math.max(temp,l+r+root.val);
        res = Math.max(ans,res);
        return temp;
    }
