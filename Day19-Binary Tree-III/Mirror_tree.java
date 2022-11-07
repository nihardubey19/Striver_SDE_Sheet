    // Using BFS : 
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    void mirror(Node node) {
        if(node==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- != 0){
                Node curr = q.poll();
                Node temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
    }

// -------------------------------------------------------------

    // Using DFS
    // Time Complexity : O(n)
    // Auxillary Stack Space : O(h) height of binary tree

    void mirror(Node node) {
        if(node==null) return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirror(node.left);
        mirror(node.right);
    }
