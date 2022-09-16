// Link of the below problem , Using Queue
// https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/

//  Time Complexity : O(n) 
//  Space Complexity : O(n)

    public String solve(String A) {
        int[] arr = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = A.length();
        
        for(int i=0; i<n; i++){
            char ch = A.charAt(i);
            arr[ch-97]++;
            q.add(ch);
            while(!q.isEmpty() && arr[q.peek()-97] > 1){
                q.poll();
            }
            
            if(!q.isEmpty())
                sb.append(q.peek());
            else
                sb.append('#');
        }
        return sb.toString();
    }
