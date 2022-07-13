	// solved using 2 pass 
	// one for counting nodes
	// another one for our task
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // least number of nodes 1 and n varies from 1 to no. of nodes
        if(n==1 && head.next==null)
            return head.next;
        
        int count = countNodes(head);
        int k = count-n;
        if(k==0)
            return head.next;
        int c = 1;
        ListNode temp = head;
        while(temp!=null){
            if(c==k){
                temp.next = temp.next.next;
            }
            c++;
            temp = temp.next;
        }
        return head;
        
    }
    
    private int countNodes(ListNode head){
        int cnt = 0;
        while(head!=null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
