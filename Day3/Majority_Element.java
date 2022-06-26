    // Using Sorting O(nlogn) :

    public int majorityElement(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        
        int count=1, ans=0;
        Arrays.sort(nums);
        int prev=nums[0];
        for(int i=1; i<n; i++){
            if(prev==nums[i]){
                count++;
            }else{
                if(count>n/2)
                    ans = prev;
                prev = nums[i];
                count=1;
            }
        }
        if(count>n/2) ans=prev;
        return ans;   
    }

// -------------------------------------
    
    // Using HashMap
    // Time: O(n) and Space: O(n)

    public int majorityElement(int[] nums) {
        int n=nums.length;
    
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        
        int ans = 0;
        for(int key: map.keySet()){
            if(map.get(key)>n/2){
                ans = key;
            }
        }
        return ans;
    }

// --------------------------------------------------

    // Using Brute Force
    // Time: O(N^2) and Space: O(1)
    
    public int majorityElement(int[] nums) {
        int n=nums.length;

        int ans = 0;
        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(nums[i]==nums[j])
                    count++;
            }
            if(count>n/2)
                ans = nums[i];
        }
        return ans;
    }

// --------------------------------------------------

    // Using Boyer's Moore Algorithm
    // Time: O(n) and Space: O(1)

    public int majorityElement(int[] nums) {
        int n=nums.length;
        
        int cand = findCandidate(nums, n);
        if(isMajority(nums, cand, n))
            return cand;
        return -1;
    }
    
    private boolean isMajority(int[] nums, int cand, int n){
        int count=0;
        for(int x: nums){
            if(x==cand) count++;
        }    
        if(count>n/2) return true;
        return false;
    }
    
    private int findCandidate(int[] nums, int n){
        int ansIdx = 0;
        int count=1;
        for(int i=1; i<n; i++){
            if(nums[ansIdx]==nums[i]){
                count++;
            }else{
                count--;
            }
            
            if(count==0){
                ansIdx = i;
                count=1;
            }
        }
        return nums[ansIdx];

