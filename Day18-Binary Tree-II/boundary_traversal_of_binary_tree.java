    // Time Complexity : O(N)
    // Space Complexity : O(N)

    public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        helper(root, ans);
        return ans;
	}
    
    private static void helper(TreeNode root, ArrayList<Integer> ans){
        if(isLeaf(root)==false)
            ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
    }
    
    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans){
        TreeNode curr = root.left;
        while(curr!=null){
            if(isLeaf(curr)==false)
                ans.add(curr.data);
            if(curr.left!=null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    
    private static void addRightBoundary(TreeNode root, ArrayList<Integer> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while(curr!=null){
            if(isLeaf(curr)==false)
                temp.add(curr.data);
            if(curr.right!=null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for(int i=temp.size()-1; i>=0; i--){
            ans.add(temp.get(i));
        }
    }
    
    private static void addLeaves(TreeNode root, ArrayList<Integer> ans){
        if(isLeaf(root)==true)
            ans.add(root.data);
        if(root.left!=null)
            addLeaves(root.left, ans);
        if(root.right!=null)
            addLeaves(root.right, ans);
    }
    
    private static boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
