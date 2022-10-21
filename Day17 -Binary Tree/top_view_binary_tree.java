    // Time Complexity : O(n)
    // Space Complexity : O(n)

    static class Pair{
        Node node;
        int dist;
        public Pair(Node _node, int _dist){
            node = _node;
            dist = _dist;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size--!=0){
                Node curr = q.peek().node;
                int dist = q.peek().dist;
                q.poll();
                
                if(!map.containsKey(dist)){
                    map.put(dist, curr.data);
                }
                
                if(curr.left!=null){
                    q.add(new Pair(curr.left, dist-1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right, dist+1));
                }
            }
        }
        
        for(int value: map.values()){
            ans.add(value);
        }
        return ans;
    }
