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
