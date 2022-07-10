    // Using Sorting O(nlogn)

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return n;
        Arrays.sort(nums);
        int count=1, prev=nums[0], max=0;
        for(int i=1; i<n; i++){
            if(prev==nums[i])
                continue;
            if(prev+1==nums[i]){
                count++;
            }else{
                max = Math.max(count, max);
                count=1;    
            }
            prev = nums[i];
        }
        max = Math.max(count,max);
        return max;
    }

// ---------------------------------------------------
 
   // Using O(n) space and O(n) Time Complexity : 
    
   public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums)
            set.add(x);
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: set){
            map.put(x, 1);
        }
        
        int max = 0;
        for(int x: set){
            if(map.get(x)==1){
                map.put(x,0);
                int count=1;
                int t = x-1;
                while(map.containsKey(t) && map.get(t)==1){
                    count++;
                    map.put(t,0);
                    t--;
                }
                t = x+1;
                while(map.containsKey(t) && map.get(t)==1){
                    count++;
                    map.put(t,0);
                    t++;
                }
                
                max = Math.max(count,max);
            }
        }
        return max;
    }
