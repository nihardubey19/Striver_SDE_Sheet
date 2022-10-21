    // Recursive Approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

// ---------------------------------------------------------------

    // Iterative Approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> st = new ArrayDeque<>();
        Deque<Integer> out = new ArrayDeque<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            out.push(temp.val);
            if(temp.left!=null)
                st.push(temp.left);
            if(temp.right!=null)
                st.push(temp.right);
        }

        while(!out.isEmpty()){
            ans.add(out.pop());
        }
        return ans;
    }
