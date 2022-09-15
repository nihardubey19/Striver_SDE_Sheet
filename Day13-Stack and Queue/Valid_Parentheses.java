    // Time Complexity : O(N) for traversing the string 
    // Space Complexity : O(n) for extra DS (stack)
    
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(char ch: s.toCharArray()){
            if(ch==')'){
                if(!st.isEmpty() && st.peek()=='(')
                    st.pop();
                else st.push(ch);
            }else if(ch=='}'){
                if(!st.isEmpty() && st.peek()=='{')
                    st.pop();
                else st.push(ch);
            }else if(ch==']'){
                if(!st.isEmpty() && st.peek()=='[')
                    st.pop();
                else st.push(ch);
            }else{
                st.push(ch);
            }
        }
        return st.size()==0 ? true : false;
    }
