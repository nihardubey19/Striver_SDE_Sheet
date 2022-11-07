    // Using DFS
    // Time Complexity : O(n)

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

// ------------------------------------------------------------------------

    // Using BFS
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root);
    }

    public boolean isMirror(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p=queue.poll();
            TreeNode q=queue.poll();
            if(p==null && q==null)
                continue;
            if(p==null || q==null)
                return false;
            if(p.val!=q.val)
                return false;
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
