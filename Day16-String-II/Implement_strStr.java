    // Time Complexity : O(n*m) // substring complexity -> O(n) + outer for loop
    // Space Complexity : O(1)

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for(int i=0; i<=m-n; i++){
            if(haystack.substring(i,i+n).equals(needle))
                return i;
        }
        return -1;
    }

//------------------------------------------------------------------------------

    // Using KMP Solution 
    // Time Complexity : O(n+m)
    // Space Complexity : O(m)
    // Standard as well as very complicated Alogrithm : 

    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int[] lps = lps(needle);
        int i=0, j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0)
                    i++;
                else
                    j = lps[j-1];
            }
            if(j==needle.length())
                return i-needle.length();
        }
        return -1;
    }
    
    private int[] lps(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];
        int j=0, i=1;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(j)){
                lps[i] = j+1;
                j++;
                i++;
            }else{
                if(j==0){
                    lps[i] = 0;
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }

