    // Time Complexity : O(n)
    // Space Complexity : O(n)

public class Stack {
    int[] arr;
    int top = -1;
    public Stack(int n){
        arr = new int[n];
    }
    
    void push(int num) {
        // Write your code here.
        if(top==arr.length-1) return;
        arr[++top] = num;
    }
    int pop() {
        // Write your code here.
        if(top==-1) return -1;
        return arr[top--];
    }
    int top() {
        // Write your code here.
        if(top==-1) return -1;
        return arr[top];
    }
    int isEmpty() {
        // Write your code here.
        if(top==-1) return 1;
        return 0;
    }
    int isFull() {
        // Write your code here.
        if(top==arr.length) return 1;
        return 0;
    }
}
