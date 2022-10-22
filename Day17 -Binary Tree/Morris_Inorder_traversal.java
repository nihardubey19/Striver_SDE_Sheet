    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // using Morris Inorder traversal
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                ans.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev = prev.right;
                }
                
                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;        
    }
