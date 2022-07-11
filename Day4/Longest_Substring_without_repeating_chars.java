    // Using Brute Force O(n^2)

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        if(n<=1)
            return n;
         
        for(int i=0; i<n; i++){
            Set<Character> set = new HashSet<>();
            int j=i;
            for(; j<n; j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    max = Math.max(max, j-i);
                    break;
                }
                set.add(ch);
            }
            if(j==n){
                max = Math.max(max, j-i);
            }
        }
        
        return max;
    }

// ----------------------------------------------------
   // using Sliding Window O(n) 
   
   public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1)
            return n;
         
        Map<Character,Integer> map = new HashMap<>();
        int i=0, j=0, max = Integer.MIN_VALUE;
        while(j<n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.size()==j-i+1){
                max = Math.max(j-i+1, max);
            }
            else if(map.size() < j-i+1){
                while(map.size() < j-i+1){
                    char x = s.charAt(i);
                    if(map.get(x)-1>0)
                        map.put(x, map.get(x)-1);
                    else
                        map.remove(x);
                    i++;
                }
                if(map.size()==j-i+1){
                    max = Math.max(j-i+1, max);
                }
            }
            j++;
        }
        return max!=Integer.MIN_VALUE ? max : 0;
    }

