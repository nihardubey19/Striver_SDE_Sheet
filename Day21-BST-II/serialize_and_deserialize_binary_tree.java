    // Time Complexity : O(N)
    // Space Complexity : O(N)

    // Encodes a tree to a single string
    public String serialize(TreeNode root) { 
        Queue<TreeNode> q = new LinkedList<>(); 
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- !=0){
                TreeNode curr = q.poll();
                if(curr==null){
                    sb.append("n ");
                    continue;
                }
                sb.append(curr.val+" ");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        if(data.charAt(0)=='n') return null;

        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1; i<arr.length; i++){
            TreeNode curr = q.poll();
            if(!arr[i].equals("n")){
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            if(!arr[++i].equals("n")){
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
        }
        return root;
    }
