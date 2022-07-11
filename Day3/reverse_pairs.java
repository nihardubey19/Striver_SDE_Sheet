    // Using Brute Force O(n^2)
    // throws TLE : 
    
    public int reversePairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(nums[i] > 2*nums[j])
                    count++;
            }
        }
        return count;
    }

// ---------------------------------------------
   
    // Using with the help of mergeSort O(nlogn)

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int low, int high){
        if(low>=high)
            return 0;
        int mid = (low + high)/2;
        int inv = mergeSort(nums, low, mid);
        inv+= mergeSort(nums, mid+1, high);
        inv+= merge(nums, low, mid, high);
        return inv;
    }
    
    private int merge(int[] nums, int low, int mid, int high){
        int count=0;
        int j=mid+1;
        for(int i=low; i<=mid; i++){
            while(j<=high && nums[i] > (2 * (long) nums[j])){
                j++;
            }
            count+=(j-(mid+1));
        }
        
        List<Integer> temp = new ArrayList<>();
        
        int left = low, right = mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }
        
        while(left<=mid){
            temp.add(nums[left++]);
        }
        while(right<=high){
            temp.add(nums[right++]);
        }
        
        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
        return count;
    }

