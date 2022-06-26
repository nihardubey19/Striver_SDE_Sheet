    // Using Brute Force : 
    // Time: O(N^2)

    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(nums[i]==nums[j])
                    count++;
            }
            if(count>n/3)
                set.add(nums[i]);
        }
        return new ArrayList<>(set);
    }

    // ----------------------------------
    // Using HashMap:
    // Time : O(N) and Space: O(N)

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key)>n/3)
                set.add(key);
        }
        return new ArrayList<>(set);
    }

    // ------------------------------------
    // Using Extended Mayor's Boore Algo.
    // Time : O(n) and Space : O(1)

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        return Majority(nums, n);
    }

    private List<Integer> Majority(int[] nums, int n){
        int count1 = 0, count2 = 0;
        int num1 = -1, num2 = -1;

        for(int i=0; i<n; i++){
            if(nums[i] == num1)
                count1++;
            else if(nums[i] == num2)
                count2++;
            else if(count1==0){
                num1 = nums[i];
                count1=1;
            }else if(count2==0){
                num2 = nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == num1)
                count1++;
            if(nums[i] == num2)
                count2++;
        }
        Set<Integer> set = new HashSet<>();

        if(count1>n/3)
            set.add(num1);
        if(count2>n/3)
            set.add(num2);

        return new ArrayList<>(set);
    }
