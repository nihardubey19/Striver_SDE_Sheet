    // Using Recusion + Memoization 
    private int[][] dp; 
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int[] t: dp)
            Arrays.fill(t, -1);
        return helper(0, 0, m, n);
    }
    
    private int helper(int i, int j, int m, int n){
        if(i==m-1 && j==n-1)
            return 1;
        if(i==m || j==n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j] = helper(i+1, j, m, n) + helper(i, j+1, m, n);
        return dp[i][j];
    }

//  ------------------------------------------------
    
    // using Recursion ;
    // Throws TLE

    private int count=0;
    public int uniquePaths(int m, int n) {
        helper(0, 0, m, n);
        return count;
    }
    
    private void helper(int i, int j, int m, int n){
        if(i==m-1 && j==n-1)
            count++;
        if(i==m || j==n)
            return;
        helper(i+1, j, m, n);
        helper(i, j+1, m, n);
    }

