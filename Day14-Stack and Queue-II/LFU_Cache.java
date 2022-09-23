    // Time Complexity : O(1) both put and get Operations
    // Extended Version of LRU Cache

class LFUCache {
    final int capacity;
    int size;
    int minFreq;
    Map<Integer,DoublyLinkedList> frequencyMap;
    Map<Integer,Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        frequencyMap = new HashMap<>();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        Node curNode = cache.get(key);
        if(curNode==null) return -1;
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        if(cache.containsKey(key)){
            Node curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }else{
            size++;
            if(size>capacity){
                DoublyLinkedList minFreqList = frequencyMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                size--;
            }
            
            minFreq = 1;
            Node newNode = new Node(key, value);
            DoublyLinkedList curList = frequencyMap.getOrDefault(1,new DoublyLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key,newNode);
        }
    }
    
    private void updateNode(Node curNode){
        int curFreq = curNode.frequency;
        DoublyLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        
        if(curFreq==minFreq && curList.listSize==0)
            minFreq++;
        
        curNode.frequency++;
        
        DoublyLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoublyLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency,newList);
    }
    
    static class Node{
        int key, val;
        int frequency;
        Node prev, next;
        public Node(int _key, int _val){
            key = _key;
            val = _val;
            frequency = 1;
        }
    }
    
    static class DoublyLinkedList{
        int listSize = 0;
        Node head;
        Node tail;
        public DoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(Node curNode){
            Node nextNode = head.next;
            head.next = curNode;
            curNode.prev = head;
            curNode.next = nextNode;
            nextNode.prev = curNode;
            listSize++;
        }
        
        public void removeNode(Node curNode){
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            listSize--;
        }
    }
}
