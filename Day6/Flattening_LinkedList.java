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

// More Optimized Solution
// using Time : O(summation of all nodes) and Space : O(1)

    Node flatten(Node root)
    {
	// Your code here
	    if(root==null || root.next==null)
	        return root;
	    root.next  = flatten(root.next);
	    
	    root = mergeTwoLists(root, root.next);
	    return root;
    }
    
    Node mergeTwoLists(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a!=null && b!=null){
            if(a.data < b.data){
                temp.bottom = a;
                a = a.bottom;
            }else{
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }
        
        if(a!=null)
            temp.bottom = a;
        else
            temp.bottom = b;
        return res.bottom;
    }
