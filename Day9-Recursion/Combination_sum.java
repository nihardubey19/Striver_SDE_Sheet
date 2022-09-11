    // Time Complexity : O(2^t * k), t is target, k is average length 
    // Space Complexity : O(x*k), x no. of combinations, k of k length

    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(0, candidates, target, new LinkedList<>());
        return ans;
    }
    
    private void helper(int idx, int[] arr, int target, LinkedList<Integer> list){
        if(idx==arr.length){
            if(target==0)
                ans.add(new ArrayList<>(list));
            return;
        }
        
        if(target>=arr[idx]){
            list.add(arr[idx]);
            helper(idx, arr, target-arr[idx], list);
            list.removeLast();
        }
        helper(idx+1, arr, target, list);
    }
