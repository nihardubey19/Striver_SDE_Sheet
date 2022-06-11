   // Using Time O(n)
   public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSofar = prices[0];
        for(int i=0; i<prices.length; i++){
            minSofar = Math.min(minSofar, prices[i]);
            int profit = prices[i] - minSofar;
            maxProfit = Math.max(profit, maxProfit);
        }
        
        return maxProfit;
    }

    // Using Time O(n^2)

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(prices[i]<prices[j]){
                    maxProfit = Math.max(prices[j]-prices[i],maxProfit);
                }
            }
        }
        return maxProfit;               
    }

