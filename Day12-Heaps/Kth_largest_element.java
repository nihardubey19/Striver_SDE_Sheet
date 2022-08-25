// Time Complexity : O(nlogk) 
// Space Complexity : O(n)

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int x: nums){
            pq.add(x);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
