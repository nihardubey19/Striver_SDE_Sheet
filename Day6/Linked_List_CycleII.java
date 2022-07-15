    // using Set, Time Complexity : O(n) and Space Complexity : O(n)
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

// ----------------------------------------------------------------
    
    // using Time Complexity : O(n) and Space Complexity : O(1)

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;
        
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode slow2 = head;
                while(slow2!=slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
