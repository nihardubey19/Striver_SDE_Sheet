     // Using Space Complexity :- O(n), Time Complexity :- O(n)

     public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            l.add(temp.val);
            temp = temp.next;
        }
        
        return isPalindrome(l);
    }
    
    private boolean isPalindrome(List<Integer> list){
        int j=list.size()-1;
        int i=0;
        while(i<j){
            if(list.get(i)!=list.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

// -------------------------------------------------------------
    // using slow and fast pointer to find mid point of linkedlist
    // then from mid reverse the linked list 
    // at the end traverse the ll from head as well as slow
    // whether it is a palindrome or not.

    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // means nodes are odd
        if(fast!=null)
            slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if(fast.val!=slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode root){
        ListNode prev = null, temp = root, forw = null;
        while(temp!=null){
            forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forw;
        }
        return prev;
    }
