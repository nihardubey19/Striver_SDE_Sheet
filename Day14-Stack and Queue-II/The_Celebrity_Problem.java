import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
public class Solution {
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
}
