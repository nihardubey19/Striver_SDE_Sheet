     // Using Set, Time Comp:- O(n) and Space Comp :- O(n)

     public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        
        while(head!=null){
            if(set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

// --------------------------------------------------------------
   
    // Using slow and fast pointer, Time Complexit :- O(n)
    // Space Complexity :- O(1)

    public boolean hasCycle(ListNode head) {
        // using slow and fast pointer
        if(head==null)
            return false;
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
