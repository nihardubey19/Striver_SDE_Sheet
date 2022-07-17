//  using Time Complexity O(n+m) and Space Complexity :- O(N) + O(N)
//  for creating a new node as well as heap

    Node flatten(Node root)
    {
	// Your code here
        Queue<Node> pq = new PriorityQueue<>((n1, n2)->{
            return n1.data - n2.data;
        });
        
        Node temp = root;
        while(temp!=null){
            pq.add(temp);
            temp = temp.next;
        }
        
        Node dummyHead = new Node(0);
        temp = dummyHead;
        
        while(!pq.isEmpty()){
            Node n = pq.poll();
            temp.bottom = new Node(n.data);
            temp = temp.bottom;
            if(n.bottom!=null){
                pq.add(n.bottom);
            }
        }
        return dummyHead.bottom;
    }
