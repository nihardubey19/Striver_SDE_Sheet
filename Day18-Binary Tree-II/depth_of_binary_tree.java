    // using DFS
    // Time Complexity : O(n)
    // Space Complexity : O(1) + recursive stack O(H)  -> h: height 

    public int maxDepth(TreeNode root) {
        return helper(root);
    }
    
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return 1+Math.max(left,right);
    }

// ----------------------------------------------------------------------
    
    // Using BFS
    // Time Complexity : O(N)
    // Space Complexity : O(n)

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.add(root);
        TreeNode front=null;
        int height=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            while(size-- != 0){
                front=queue.poll();
                if(front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
            }
            height++;
        }
        return height;
    }
