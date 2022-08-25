// Time Complexity : O(N) + O(Nlogk)
// Space Complexity : O(N)

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        Queue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int x: map.keySet()){
            pq.add(x);
            if(pq.size()>k)
                pq.poll();
        }
        
        int idx = 0;
        int[] ans = new int[pq.size()];
        while(!pq.isEmpty()){
            ans[idx++] = pq.peek();
            pq.poll();
        }
        return ans;
    }
