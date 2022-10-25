    // Time Complexity : O(N)
    // Space Complexity : O(1) + O(H) stack space 

    private int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDia;
    }
    
    private int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int temp = 1 + Math.max(left,right);
        
        maxDia = Math.max(left+right,maxDia);
        return temp;
    }
