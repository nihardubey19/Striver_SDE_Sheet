    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        if(l1!=null && l1==null)
            return l1;
        if(l1==null && l2!=null)
            return l2;
        
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int x=0, y=0;
            if(l1!=null){
                x = l1!=null ? l1.val : 0;
                l1 = l1.next;
            }
            if(l2!=null){
                y = l2!=null ? l2.val : 0;
                l2 = l2.next;
            }
            int sum = (x+y+carry)%10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            carry = (x+y+carry)/10;
        }
        return dummyHead.next;
    }
