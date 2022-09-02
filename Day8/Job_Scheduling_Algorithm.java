    // Time Complexity : O(nlogn) + O(n*m)
    // Space Complexity : O(m) 

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b)->{
            return b.profit - a.profit;  
        });
         
        int maxi =0;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        
        int[] ans = new int[maxi+1];
        Arrays.fill(ans,-1);
        
        int countJob=0;
        int maxProfit=0;
        for(int i=0; i<n; i++){
            for(int j=arr[i].deadline; j>0; j--){
                if(ans[j]==-1){
                    ans[j] = arr[i].id;
                    countJob++;
                    maxProfit+=arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{countJob, maxProfit};
    }

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
           this.id = x;
           this.deadline = y;
           this.profit = z;
        }
    }
