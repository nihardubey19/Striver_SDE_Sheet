// Time Complexity: O(2nlogn) + O(Math.max(A.size(),k) + O(nlogk)
// Space Complexity: O(n)

     public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int k) {
        Collections.sort(A, (a,b)->b-a);
        Collections.sort(B, (a,b)->b-a);
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->b.sum-a.sum);
        for(int i=0; i<A.size(); i++){
            pq.add(new Triple(i, 0, A.get(i)+B.get(0)));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            int val = pq.peek().sum;
            int x= pq.peek().i;
            int y= pq.peek().j;
            pq.poll();
            
            ans.add(val);
            if(y==B.size()-1)
                continue;
            pq.add(new Triple(x,y+1,A.get(x)+B.get(y+1)));
        }
        return ans;
    }
    
    static class Triple{
        int i;
        int j;
        int sum;
        public Triple(int i, int j, int sum){
            this.i=i;
            this.j=j;
            this.sum=sum;
        }
    }
