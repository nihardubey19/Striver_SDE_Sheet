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

// ----------------------------------------------
 
    // Using Sorting O(nlogn) 

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] temp = new int[n];
        
        for(int i=0; i<n; i++){
            temp[i] = nums[i];
        }
        
        Arrays.sort(nums);
        
        int n1=0, n2=0;
        int left = 0, right = n-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==target){
                n1 = nums[left];
                n2 = nums[right];
                break;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        
        boolean f = false;
        int[] ans = new int[2];
        for(int i=0; i<n; i++){
            if(f==false && temp[i] == n1){
                ans[0] = i;
                f = true;
            }
            else if(temp[i] == n2){
                ans[1] = i;
            }
        }
        return ans;
    }

