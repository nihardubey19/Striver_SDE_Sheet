    // Using O(N)
    // throws TLE : 

    public double myPow(double x, int n) {
        return fun(x, n);
    }
    
    private double fun(double x, int n){
        int nn=n;
        if(nn<1)
            nn=-1 * nn;
        double result=1.0;
        for(int i=1; i<=nn; i++){
            result=result*x;
        }
        
        if(n<1)
            return (double)(1.0) / (double)(result);
        return result;
    }

// ----------------------------------------------------------
 

    // Using O(logn):

    public double myPow(double x, int n) {
        return fun(x, n);
    }

    private double fun(double x, int n){
        long nn=n;
        if(nn<1)
            nn = -nn;

        double ans = 1.0;
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }else{
                x=x*x;
                nn=nn/2;
            }
        }

        if(n<1) return (double)(1.0) / (double)(ans);
        return ans;
    }

