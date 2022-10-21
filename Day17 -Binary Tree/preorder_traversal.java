    // Recursive Approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

// --------------------------------------------------------------

    // Iterative Approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            while(temp!=null){
                ans.add(temp.val);
                if(temp.right!=null)
                    st.push(temp.right);
                temp = temp.left;
            }
        }
        return ans;
    }
