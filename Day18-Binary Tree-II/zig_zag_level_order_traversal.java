    // Using Deque
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        // flag==false -> right to left
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size--!=0){
                if(flag==false){
                    Node curr = q.pollLast();
                    ans.add(curr.data);
                    if(curr.right!=null)
                        q.addFirst(curr.right);
                    if(curr.left!=null)
                        q.addFirst(curr.left);
                }else{
                    Node curr = q.pollFirst();
                    ans.add(curr.data);
                    if(curr.left!=null)
                        q.addLast(curr.left);
                    if(curr.right!=null)
                        q.addLast(curr.right);
                }
            }
            if(flag==false) flag=true;
            else flag=false;
        }
        return ans;
    }
