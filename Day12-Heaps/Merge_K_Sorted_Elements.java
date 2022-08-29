// Time Complexity : O(nlogk)
// Space Complexity : O(n)

     public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> Arrays, int k){
	// Write your code here.
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0; i<k; i++){
             pq.add(new Triple(i,0,Arrays.get(i).get(0)));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            ans.add(t.val);
            int i=t.i;
            int j=t.j;
            if(j==Arrays.get(i).size()-1)
                continue;
            pq.add(new Triple(i,j+1,Arrays.get(i).get(j+1)));
        }
        return ans;
     }
    
     static class Triple{
        int i;
        int j;
        int val;
        public Triple(int _i, int _j, int _val){
            i = _i;
            j = _j;
            val = _val;
        }
    }
