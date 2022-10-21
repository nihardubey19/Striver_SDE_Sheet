    // Using Recursion 

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }

// -----------------------------------------------------------

    // Using Iterative 

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        TreeNode temp = root;
        Deque<TreeNode> st = new ArrayDeque<>();
        do{
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            temp = st.pop();
            while(temp!=null){
                ans.add(temp.val);
                if(temp.right!=null){
                    temp = temp.right;
                    break;
                }
                
                if(!st.isEmpty()){
                    temp = st.pop();
                }else{
                    return ans;
                }
            }
        }while(temp!=null);
        return ans;        
    }
