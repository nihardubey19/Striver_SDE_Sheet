    // Using Set, Time Complexity -> O(m+n), Space Complexity -> O(m)
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while(temp!=null){
            set.add(temp);
            temp = temp.next;
        }
        
        while(headB!=null){
            if(set.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
