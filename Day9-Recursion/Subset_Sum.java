    // Time Complexity :- O(2^n)
    // Space Complexity :- O(2^n)
  
    private ArrayList<Integer> list;
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        list = new ArrayList<>();
        helper(0, arr, N, 0);
        return list;
    }
    
    private void helper(int idx, ArrayList<Integer> arr, int n, int sum){
        if(idx==n){
            list.add(sum);
            return;
        }
        
        sum+=arr.get(idx);
        helper(idx+1, arr, n, sum);
        sum-=arr.get(idx);
        helper(idx+1, arr, n, sum);
    }
