    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null, temp=null, prev=null;
        for(int x: preorder){
            TreeNode p = new TreeNode(x);
            if(root==null)
                root = p;
            else{
                temp = root;
                while(temp!=null){
                    prev = temp;
                    if(temp.val>x)
                        temp = temp.left;
                    else
                        temp = temp.right;
                }
                if(prev.val>x)
                    prev.left = p;
                else
                    prev.right = p;
            }
        }
        return root;
    }
