//  using 3 variables
//  In-2 pass
    public void sortColors(int[] nums) {
        int x = 0, y = 0, z = 0;
        for(int t: nums){
            if(t==0)
                x++;
            else if(t==1)
                y++;
            else
                z++;
        }
        
        for(int i=0; i<nums.length; i++){
            if(x>0){
                nums[i] = 0;
                x--;
            }
            else if(y>0){
                nums[i] = 1;
                y--;
            }else{
                nums[i] = 2;
            }
        }
    }

// using Dutch National Flag Algorithm
// single pass, Time->O(1)

   public void sortColors(int[] nums) {
        int n = nums.length;
        int mid = 0, low = 0, high = n-1;

        while(mid<=high){
            if(nums[mid]==2){
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }else if(nums[mid]==1){
                mid++;
            }else if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                mid++;
                low++;
            }
        }
    }
