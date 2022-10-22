    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Using Pair class and BFS

    static class Pair{
        TreeNode node;
        int level;
        public Pair(TreeNode _node, int _level){
            node = _node;
            level = _level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            
            if(!q.isEmpty()){
                int first = q.peekFirst().level;
                int last = q.peekLast().level;
                max = Math.max(last-first+1, max);
            }
            
            while(size-- != 0){
                TreeNode curr = q.peek().node;
                int level = q.peek().level;
                q.poll();
                
                if(curr.left!=null){
                    q.add(new Pair(curr.left, 2*level+1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right, 2*level+2));
                }
            }
        }
        return max;
    }
