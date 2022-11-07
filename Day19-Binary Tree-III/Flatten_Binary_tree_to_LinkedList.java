    // Using Stack
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public void flatten(TreeNode root) {
        if(root==null) return;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null)
                st.push(curr.right);
            if(curr.left!=null)
                st.push(curr.left);
            curr.left = null;
            if(!st.isEmpty())
                curr.right = st.peek(); 
        }
    }
