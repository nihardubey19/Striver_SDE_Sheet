    // Most IMP Question!!
    // Using Brute Force O(n^2)

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

// ----------------------------------------------------
    
    // Using Prefix_sum and HashMap
    // Time complexity : O(n)

    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int count=0, n = arr.size();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int k: arr){
            sum^=k;
            int t = sum^x;
            if(map.containsKey(t)){
                count+=map.get(t);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

