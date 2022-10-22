    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public ArrayList<Integer> solve(TreeNode root, int B) { 
        LinkedList<Integer> temp = new LinkedList<>();
        helper(root, temp, B);
        return new ArrayList<>(temp);
    }
    
    private boolean helper(TreeNode root, LinkedList<Integer> list, int target){
        if(root==null) return false;
        list.add(root.val);
        
        if(root.val==target) return true;
        
        if(helper(root.left, list, target)==true) return true;
        if(helper(root.right, list, target)==true) return true;
        list.removeLast();
        return false;
    }
