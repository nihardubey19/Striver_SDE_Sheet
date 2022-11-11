    // Time Complexity : O(n)
    // Space Complexity : O(1)


    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
        Node predecessor = null, successor = null;
        Node temp = root;
        while(temp!=null){
            if(key>=temp.data){
                temp = temp.right;
            }else{
                successor = temp;
                temp = temp.left;
            }
        }
        
        temp = root;
        while(temp!=null){
            if(temp.data>=key){
                temp = temp.left;
            }else{
                predecessor = temp;
                temp = temp.right;
            }
        }
        
        p.pre = predecessor;
        s.succ = successor;
    }
