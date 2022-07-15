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

// ------------------------------------------------------------------------

    // Using Time Complexity : O(m+n), Space Complexit -> O(1)

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = countNodes(headA);
        int n = countNodes(headB);
        
        while(m>n){
            headA = headA.next;
            m--;
        }
        while(n>m){
            headB = headB.next;
            n--;
        }
        
        while(headA!=null && headB!=null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int countNodes(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;
        }
        return cnt;
    }

