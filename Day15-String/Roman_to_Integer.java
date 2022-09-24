    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int sum = map.get(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            int prev = map.get(s.charAt(i-1));
            int curr = map.get(s.charAt(i));
            
            if(prev<curr){
                sum=sum - 2*prev;
            }
            sum+=curr;
        }
        return sum;
    }
