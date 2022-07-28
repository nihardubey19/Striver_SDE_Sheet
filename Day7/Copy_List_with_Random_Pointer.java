    // Using Time Complexit: O(n)
    // Space Complexity: O(n) for Map + O(n) for new Node
	
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Map<Node,Node> map = new HashMap<>();
        
        Node temp = head;
        Node dummyHead = new Node(-1), node = dummyHead;
        while(temp!=null){
            node.next = new Node(temp.val);
            map.put(temp, node.next);    
            node = node.next;
            temp = temp.next;
        }
        
        temp = head;
        while(temp!=null){
            Node clonedNode = map.get(temp);
            if(temp.random!=null)
                clonedNode.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return dummyHead.next;
    }
