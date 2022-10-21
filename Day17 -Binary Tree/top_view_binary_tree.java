    // Time Complexity : O(n)
    // Space Complexity : O(n)

    // using Queue Data Strucrture
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
        
        for(int value: map.values()){
            ans.add(value);
        }
        return ans;
    }

// -------------------------------------------------------------

    // Time Complexity : O(nlogn)
    // Space Complexity : O(n)
    // without using queue

    static class Pair{
        int first;
        int second;
        public Pair(int _first, int _second){
            first = _first;
            second = _second;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Pair> map = new TreeMap<>();
        helper(root, 0, 0, map);

        for(Map.Entry<Integer,Pair> e : map.entrySet()){
            ans.add(e.getValue().first);
        }
        return ans;
    }

    static void helper(Node root, int d, int curlevel, Map<Integer,Pair> map){
        if(root==null) return;

        if(!map.containsKey(d) || map.get(d).second>curlevel)
            map.put(d, new Pair(root.data, curlevel));

        helper(root.left, d-1, curlevel+1, map);
        helper(root.right, d+1, curlevel+1, map);
    }
