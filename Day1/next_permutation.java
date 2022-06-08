class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0){
            if(nums[i]<nums[i+1])
                break;
            i--;
        }
        
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(i,j,nums);
        }
        reverse(i+1, nums);
    }
    
    private void reverse(int l, int[] arr){
        int h = arr.length-1;
        while(l<h){
            swap(l,h,arr);
            l++;
            h--;
        }
    }
    
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
