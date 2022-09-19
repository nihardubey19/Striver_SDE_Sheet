     /*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
    */
    public static int findCelebrity(int n) {
        // Using O(n)
        // 1. find the potential candidate
        
        int candi = 0;
        for(int i=1; i<n; i++){
            if(Runner.knows(candi,i)){
                candi = i;
            }
        }
        
        // 2. check whether the candidate is celebrity or not
        for(int i=0; i<n; i++){
            if(candi!=i){
                if(Runner.knows(i,candi)==false || Runner.knows(candi,i)==true)
                    return -1;
            }
        }
        return candi;        
    }

// ----------------------------------------------------------------------------
    
    public static int findCelebrity(int n) {
        // Using Stack 
        // Time Complexity -> O(n) and Space Complexity : O(n)
        // step 1 : put all elements into stack
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        
        // step 2 : while size>1, pop 2 elements from the stack and check knows
        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            if(Runner.knows(a,b)==true)
                st.push(b);
            else
                st.push(a);
        }
        
        // step 3 : pop the top element of stack, and check whether it is a celebrity or not
        int candi = st.pop();
        for(int i=0; i<n; i++){
            if(i!=candi){
                if(Runner.knows(candi,i)==true || Runner.knows(i,candi)==false) return -1;
            }
        }
        return candi;
    }
