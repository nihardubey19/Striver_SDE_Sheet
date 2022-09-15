   // Time Complexity : 1 operation -> O(1), n operations -> O(n) 
   // Space Complexity : O(n)

public class Queue {
    int front;
    int rear;
    int[] arr;
    Queue() {
        arr = new int[100001];
        rear=-1;
        front=0;
    }

    boolean isEmpty() {
        // Implement the isEmpty() function
        if(front==rear+1) return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        rear++;
        arr[rear] =  data;
    }

    int dequeue() {
        // Implement the dequeue() function
        if(front==rear+1)
            return -1;
        return arr[front++];
    }

    int front() {
        // Implement the front() function
        if(front==rear+1) return -1;
        return arr[front];
    }
}
