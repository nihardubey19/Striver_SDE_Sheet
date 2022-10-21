    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        root.hd = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size--!=0){
                Node curr = q.poll();
                int dist = curr.hd;
                map.put(dist, curr.data);
                
                if(curr.left!=null){
                    curr.left.hd = dist-1;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    curr.right.hd = dist+1;
                    q.add(curr.right);
                }
            }
        }
        
        for(int value: map.values()){
            ans.add(value);
        }
        return ans;
    }
