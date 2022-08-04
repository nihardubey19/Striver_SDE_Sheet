     // using Time Complexity : O(n) and Space Complexity : O(1)

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, max=0;
        
        for(int x: nums){
            if(x==1){
                count++;
            }else{
                max = Math.max(count,max);
                count=0;
            }
        }
        return Math.max(count, max);
    }
