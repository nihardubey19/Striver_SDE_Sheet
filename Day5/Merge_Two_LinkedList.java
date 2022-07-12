    // Approach 1 : 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Using external nodes
        
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        ListNode temp=null, head=null, q=null;
        while(list1!=null && list2!=null){
            ListNode node = new ListNode();
            if(head==null)
                head=node;
            else
                temp.next = node;
            temp = node;
            
            if(list1.val<list2.val){
                node.val = list1.val;
                list1 = list1.next;
            }else{
                node.val = list2.val;
                list2 = list2.next;
            }
        }
        
        if(list1!=null){
            temp.next = list1;
        }
        if(list2!=null){
            temp.next = list2;
        }
        return head;
    }

// ---------------------------------------

    // Approach 2 :

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // without creating extra nodes
        // inplace
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l2.val < l1.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        ListNode res = l1;
        while(l1!=null && l2!=null){
            ListNode prev = null;
            
            while(l1!=null && l1.val<=l2.val){
                prev = l1;
                l1 = l1.next;
            }            
            prev.next = l2;
            // l1-> must have smaller value then l2 
            // and above while loop stop when l1 becomes null or 
            // l1 becomes larger then l2
            
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }        
        return res;
    }
