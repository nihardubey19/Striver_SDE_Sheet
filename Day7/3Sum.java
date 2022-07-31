    // Using Time Complexity : O(n^2)

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3) return null;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++){
            int low = i+1;
            int high = n-1;
            while(low<high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    List<Integer> l = Arrays.asList(nums[i], nums[low], nums[high]);
                    set.add(l);
                    low++;
                    high--;
                }else if(sum>0){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return new ArrayList<>(set);
    }
