    // Using O(n^3), also using sorting, set.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-3; i++){            
            for(int j=i+1; j<n-2; j++){
                int left = j+1, right=n-1;
                while(left<right){
                    long sum = nums[i];
                    sum+= nums[j];
                    sum+=nums[left];
                    sum+=nums[right];
                    if(sum==target){
                        System.out.println(sum +" " + target);
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
