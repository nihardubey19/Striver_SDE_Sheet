    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            while(size-- !=0){
                Node curr = q.poll();
                if(curr.right!=null)
                    q.add(curr.right);
                if(curr.left!=null)
                    q.add(curr.left);
                curr.next = prev;
                prev = curr;
            }
        }
        return root;
    }
