    // Using Map and Stack
    // Time Complexity : O(n)
    // Space Complexity : O(n)
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        map.put(root, null);
        
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode curr = st.poll();
            
            if(curr.left!=null){
                map.put(curr.left, curr);
                st.push(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right, curr);
                st.push(curr.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = map.get(p);
        }
        
        while(!ancestors.contains(q)){
            q = map.get(q);
        }
        return q;
    }
