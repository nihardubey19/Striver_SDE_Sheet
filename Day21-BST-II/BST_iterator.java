// Time Complexity : O(n)
// Space Complexity : O(n)

class BSTIterator {
    Deque<TreeNode> st = new ArrayDeque();
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    private void helper(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        helper(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
