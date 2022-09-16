// Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(n)

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            int idx = map.get(nums1[i]);
            for(int j=idx+1; j<nums2.length; j++){
                if(nums1[i]<nums2[j]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

// --------------------------------------------------------------------

    // Using Stack
    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public int[] nextGreaterElement(int[] nums, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();

        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            int nextGreaterEle = -1;
            if(!st.isEmpty() && st.peek()>arr[i])
                nextGreaterEle = st.peek();
            else if(!st.isEmpty() && arr[i]>=st.peek()){
                while(!st.isEmpty() && arr[i]>=st.peek()){
                    st.pop();
                }
                if(!st.isEmpty())
                    nextGreaterEle = st.peek();
            }
            st.push(arr[i]);
            map.put(arr[i], nextGreaterEle);
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
