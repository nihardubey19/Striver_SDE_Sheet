    // Using Brute Force O(n^2)

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int sum = nums[i];
            for(int j=i+1; j<n; j++){
                sum+=nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }else
                    sum-=nums[j];
            }
        }
        return null;
    }

// ----------------------------------------------
    
    // Using HashMap, Time: O(n) and Space: O(n)

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(map.containsKey(target - nums[i])){
                int idx = map.get(target-nums[i]);
                return new int[]{idx, i};
            }else
                map.put(nums[i], i);
        }
        return null;
    }

