    // Time Complexity : O(n * logn * logn)
    // Space Complexity : O(n)
    // using TreeMap and Pair class

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer,List<Pair>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        
        for(List<Pair> list: map.values()){
            List<Integer> temp = new ArrayList<>();
            Collections.sort(list, (p1, p2)->{
                return p1.row == p2.row ? p1.val - p2.val : p1.row - p2.row;  
            });
            for(Pair p: list){
                temp.add(p.val); 
            }
            ans.add(temp);
        }
        return ans;
    }
    
    private static void helper(TreeNode root, int row, int col, Map<Integer, List<Pair>> map){
        if(root==null) return;
        
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair(row, root.val));
        helper(root.left, row+1, col-1, map);
        helper(root.right, row+1, col+1, map);
    }
    
    static class Pair{
        int row, val;
        public Pair(int _row, int _val){
            row = _row;
            val = _val;
        }
    }

// -----------------------------------------------------------------------------------------------

    // Time Complexity : O(N) * logn * logn * logn
    // Space Complexity : O(n)
    // Using TreeMap and PriorityQueue (minHeap)
  
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);

        for(Map<Integer,PriorityQueue<Integer>> tempMap : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : tempMap.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }

    private static void helper(TreeNode root, int row, int col, Map<Integer, Map<Integer,PriorityQueue<Integer>>> map){
        if(root==null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).add(root.val);

        helper(root.left, row+1, col-1, map);
        helper(root.right, row+1, col+1, map);
    }
