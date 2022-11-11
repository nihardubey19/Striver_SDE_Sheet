    // Time Complexity : O(n)
    // Space Compleixty : O(1)

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val==val)
                return temp;
            
            if(temp.val>val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return null;
    }
