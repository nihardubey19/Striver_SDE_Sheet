    // Approach 1 :

    public ListNode middleNode(ListNode head) {
        if(head==null)
            return head;
        
        int count = countNodes(head);
        int t = (count/2) + 1;
        int c=1;
        while(head!=null){
            if(c==t)
                return head;
            head = head.next;
            c++;
        }
        return null;
    }
    
    private int countNodes(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

// --------------------------------------------

    // Using slow and fast pointer
    
    public ListNode middleNode(ListNode head) {
        if(head==null)
            return head;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

