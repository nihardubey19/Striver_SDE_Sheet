    /*Time Complexity : O(2^n)*K*O(n/2) 
                     2^n -> for each substring, n/2 -> check if it is a palindrome 
                     K-> put the k length of string into the another DS
    Space Complexity : O(K*x) -> K length of list of string of x substrings

    Using Recursion : 

    */
    private List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(0, s, new LinkedList<>());
        return ans;
    }
    
    private void helper(int idx, String s, LinkedList<String> list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            String s1 = s.substring(idx,i+1);
            if(isPalindrome(s1)){
                list.add(s1);
                helper(i+1, s, list);
                list.removeLast();
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
