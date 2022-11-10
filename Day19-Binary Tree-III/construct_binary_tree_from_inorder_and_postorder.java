    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(map, inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(Map<Integer,Integer> map, int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        
        if(inStart>inEnd || postStart>postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(map, inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1);
        
        root.right = helper(map, inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1);
        
        return root;
    }

