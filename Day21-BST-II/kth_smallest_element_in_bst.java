    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        inorder(root, k, pq);
        return pq.peek();
    }

    private void inorder(TreeNode root, int k, Queue<Integer> pq){
        if(root==null) return;
        inorder(root.left, k, pq);
        pq.add(root.val);
        if(pq.size()>k)
            pq.poll();
        inorder(root.right, k, pq);
    }

// ------------------------------------------------------------------

    // Time Complexity : O(n)
    // Space Compleixty : O(1)

    public int kthSmallest(TreeNode root, int k) {
        int[] ans = {k,0};
        helper(root, ans);
        return ans[1];
    }

    private boolean helper(TreeNode root, int[] ans){
        if(root==null) return false;

        if(helper(root.left, ans)==true) return true;
        ans[0]--;
        if(ans[0]==0){
            ans[1]=root.val;
            return true;
        }
        if(helper(root.right, ans)==true) return true;

        return false;
    }
