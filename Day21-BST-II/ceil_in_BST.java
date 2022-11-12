    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public  static int findCeil(TreeNode<Integer> node, int x) {
        // Write your code here
        int ceil = -1;
        while(node!=null){
            if(node.data == x)
                return node.data;
            
            if(node.data>x){
                ceil = node.data;
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return ceil;
    }
