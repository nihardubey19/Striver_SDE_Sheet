    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public int kthLargest(Node root,int K)
    {
        //Your code here
        int[] ans = {K, 0};
        helper(root, ans);
        return ans[1];
    }
    
    private boolean helper(Node root, int[] ans){
        if(root==null) return false;
        
        if(helper(root.right, ans)==true) return true;
        ans[0]--;
        if(ans[0]==0){
            ans[1] = root.data;
            return true;
        }
        if(helper(root.left, ans)==true) return true;
        
        return false;
    }
