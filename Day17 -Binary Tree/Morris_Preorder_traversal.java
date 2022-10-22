    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // using Morris Preorder traversal
   
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
              	ans.add(curr.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev = prev.right;
                }
                
                if(prev.right==null){
                    prev.right = cur;
                    ans.add(curr.val);
		    cur = cur.left;
                }else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;        
    }
