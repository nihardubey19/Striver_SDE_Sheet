    // BFS Approach
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1; i<=size; i++){
                Node curr = q.poll();
                if(i==1)
                    ans.add(curr.data);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return ans;
    }

// ---------------------------------------------------------

    // DFS Approach
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(Node root, ArrayList<Integer> ans, int curDepth){
        if(root==null) return;
        if(ans.size()==curDepth)
            ans.add(root.data);
        dfs(root.left, ans, curDepth+1);
        dfs(root.right, ans, curDepth+1);
    }
