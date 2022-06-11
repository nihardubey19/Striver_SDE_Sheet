// Using O(mlogm)

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = 0;
        for(int i=m; i<nums1.length; i++){
            nums1[i] = nums2[idx++];
        }
        Arrays.sort(nums1);
    }
 
// Using O(m+n)

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;

        int idx = m+n-1;

        while(j>=0 && i>=0){
            if(nums1[i] <= nums2[j]){
                nums1[idx--] = nums2[j--];
            }else{
                nums1[idx--] = nums1[i--];
            }
        }

        while(j>=0){
            nums1[idx--] = nums2[j--];
        }
    }

