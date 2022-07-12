    // reverse linkedlist, in-place
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, forw=head, temp=head;
        while(temp!=null){
            forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forw;
        }
        return prev;
    }
