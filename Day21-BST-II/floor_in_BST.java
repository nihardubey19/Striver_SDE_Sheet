    // Time Complexity : O(N)
    // Space Complexity : O(1)


    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        TreeNode<Integer> temp = root;
        
        int floor = -1;
        while(temp!=null){
            if(temp.data == X){
                return temp.data;
            }
            if(temp.data>X){
                temp = temp.left;
            }else{
                floor = temp.data;
                temp = temp.right;
            }
        }
        
        return floor;
    }
