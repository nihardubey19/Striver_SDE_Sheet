    // Time Complexity : O(2^n * k)	
    // Space Complexity : O(k*x)
    
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, new LinkedList<>());
        return ans;
    }
    
    private void helper(int idx, int[] arr, int target, LinkedList<Integer> list){
        if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            list.add(arr[i]);
            helper(i+1, arr, target-arr[i], list);
            list.removeLast();
        }
    }
