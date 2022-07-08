    // Using HashMap 
    // Time: O(n) and Space O(n)
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int sum=0, max=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i=0; i<arr.size(); i++){
            sum+=arr.get(i);
            if(map.containsKey(sum)){
                max = Math.max(i-map.get(sum), max);
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }

// ---------------------------------------------------------

    // Using Brute Force 
    // Time O(n^2)
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr){
	int max = 0, n=arr.size();
	for(int i=0; i<n; i++){
		int sum=0;
		for(int j=i; j<n; j++){
			sum+=arr.get(j);
			if(sum==0)
			max = Math.max(j-i+1, max);
		}
	}
	return max;
    }

