    // Time Complexity : O(N)
    // Space Complexity : O(1)

    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        if(isValidBST(root.left)==false) return false;
        if(root.val<=prev) return false;
        prev = root.val;
        if(isValidBST(root.right)==false) return false;

        return true;
    }
