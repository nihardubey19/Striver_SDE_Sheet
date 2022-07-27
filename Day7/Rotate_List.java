    // Time Complexity: O(n) + O(n - (k%n))
    // Space Complexity : O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
            return head;
        
        int n = countNodes(head);
        k = k%n;
        if(k==0) return head;
        
        int reach = n-k, count=1;
        ListNode dummyHead = null, temp = head, prev=null;
        while(temp.next!=null){
            if(count==reach){
                dummyHead = temp.next;
                prev = temp;
            }
            count++;
            temp = temp.next;
        }
        temp.next = head;
        prev.next = null;
        return dummyHead;
    }
    
    private int countNodes(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
