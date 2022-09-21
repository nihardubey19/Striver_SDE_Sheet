    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    // using Deque :      
    // Throws TLE : 

    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int k = 1;
        int[] ans = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int idx=0; idx<n; idx++){
            int i=0, j=0;
            int max = Integer.MIN_VALUE;
            while(j<n){
                while(!dq.isEmpty() && dq.peekLast()>a[j])
                    dq.pollLast();
                dq.add(a[j]);
                if(j-i+1 == k){
                    max = Math.max(dq.peek(),max);
                    if(a[i]==dq.peek())
                        dq.poll();
                    i++;
                }
                j++;
            }
            ans[idx] = max;
            dq.clear();
            k++;
        }
        return ans;
    }

// -----------------------------------------------------------------------

    // Time Complexity : O(n) -> Using with the help of nearest smaller right, ot left
    // Space Complexity : O(3n) + O(n) -> for left, right, ans arrays and Stack Data Structures

    public static int[] maxMinWindow(int[] arr, int n) {      
        Deque<Integer> st = new ArrayDeque<>();
        int[] LSR = new int[n];
        int[] LSL = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        nearestSmallerRight(LSR, arr, st);
        st.clear();
        nearestSmallerLeft(LSL, arr, st);
        for(int i=0; i<n; i++){
            int len = LSR[i] - LSL[i] - 1;
            ans[len-1] = Math.max(ans[len-1],arr[i]);
        }
        
        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i],ans[i+1]);
        }
        return ans;
    }
    
    private static void nearestSmallerRight(int[] ans, int[] arr, Deque<Integer> st){
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = n;
            else
                ans[i] = st.peek();
            st.push(i);
        }
    } 
    
    private static void nearestSmallerLeft(int[] ans, int[] arr, Deque<Integer> st){
        int n = arr.length;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(i);
        }  
    }
