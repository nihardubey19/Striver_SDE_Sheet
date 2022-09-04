// Time Complexity : O(V) where V : 54->50->2->2 
// Space Complexity : O(1)
    public static int findMinimumCoins(int amount)
    {
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;
        int count=0;
        for(int i=n-1; i>=0; i--){
            while(amount>=arr[i]){
                amount-=arr[i];
                count++;
            }
            if(amount==0) 
                break;
        }
        return count;
    }
