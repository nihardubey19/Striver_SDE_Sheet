    // Time Complexity : O(nLogn)
    // Space Complexity : O(1)

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String first = strs[0], last = strs[n-1];
        int i=0, l = first.length();
        while(i<l){
            if(first.charAt(i) == last.charAt(i)){
                i++;
            }else{
                break;
            }
        }
        return first.substring(0,i);
    }
