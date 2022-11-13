    // Time Complexity : O(n)
    // Space Complexity : O(N)

    class BSTIterator{
        Deque<TreeNode> st = new ArrayDeque<>();
        boolean isReverse = false;

        public BSTIterator(TreeNode root, boolean reverse){
            isReverse = reverse;
            pushAll(root);
        }

        private int next(){
            TreeNode curr = st.pop();
            if(isReverse==false)
                pushAll(curr.right);
            else
                pushAll(curr.left);
            return curr.val;
        }

        private void pushAll(TreeNode root){
            TreeNode curr = root;
            while(curr!=null){
                st.push(curr);
                if(isReverse==false){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        
        while(i<j){
            if(i+j == k)
                return true;
            
            if(i+j<k)
                i = l.next();
            else
                j = r.next();
        }
        return false;    
    }
