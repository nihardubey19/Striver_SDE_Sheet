    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(map, inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    
    private TreeNode helper(Map<Integer,Integer> map, int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd){
        if(preStart>preEnd || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(map, inorder, inStart, inRoot-1, preorder, preStart+1, preStart+numsLeft);
        
        root.right = helper(map, inorder, inRoot+1, inEnd, preorder, preStart+numsLeft+1, preEnd);
        
        return root;
    }
