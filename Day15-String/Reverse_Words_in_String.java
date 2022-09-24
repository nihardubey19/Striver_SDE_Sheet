    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public String reverseWords(String s) {
        s = s.trim();
        Deque<String> st = new ArrayDeque<>();
        String str="";
        for(char ch: s.toCharArray()){
            if(ch==' '){
                if(str.length()!=0){
                    st.push(str);
                    str="";
                }
            }else{
                str+=ch;
            }
        }
        st.push(str);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop()+" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

// -------------------------------------------------------------
 
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    
    public String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        String str="";
        for(char ch: arr){
            if(ch==' '){
                if(str.length()!=0){
                    sb.insert(0," "+str);
                    str="";
                }
            }else{
                str+=ch;
            }
        }
        sb.insert(0,str);
        return sb.toString();
    }
