    // Time Complexity : O(n^2)
    // Space Complexity : O(n)

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for(int i=1; i<n; i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        
        StringBuilder sb = new StringBuilder();
        k = k-1;
        while(true){
            sb.append(list.get(k/fact));
            list.remove(k/fact);
            if(list.size()==0)
                break;
            
            k = k%fact;
            fact = fact / list.size();
        }
        return sb.toString();
    }

// ---------------------------------------------------------

    // Throws TLE :
    // Time Complexity : O(N! * N) + O(N! * logn!)
    // Space Complexity : O(N)

    private List<String> ans;
    public String getPermutation(int n, int k) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++)
            sb.append(i);
        
        helper(sb.toString().toCharArray(), 0, n);
        Collections.sort(ans);
        
        return ans.get(k-1);
    }
    
    private void helper(char[] arr, int idx, int n){
        if(idx==n){
            ans.add(String.valueOf(arr));
            return;
        }
        
        for(int i=idx; i<n; i++){
            swap(i, idx, arr);
            helper(arr, idx+1, n);
            swap(i, idx, arr);
        }
    }
    
    private void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
