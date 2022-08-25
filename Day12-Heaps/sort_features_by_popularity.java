// Time Complexity : O(n) + O(nlogn)
// Space Complexity : O(n) for 2 haspublic static void main(String[] args) {
        //System.out.println("Hello World!");
        String[] features = {"cooler", "lock", "touch"};
        String[] responses = {"i like cooler cooler", "lock touch cool", "locker like touch"};
        
        Map<String,Integer> featureMap = new HashMap<>();
        for(int i=0; i<features.length; i++){
            featureMap.put(features[i], i);
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(String response: responses){
            Set<String> set = new HashSet(Arrays.asList(response.split(" ")));
            for(String str: set){
                if(featureMap.containsKey(str))
                    map.put(str, map.getOrDefault(str,0)+1);
            }
        }
        
        Queue<Node> pq = new PriorityQueue<>((a,b)->{
            return a.freq!=b.freq ? b.freq - a.freq : a.index - b.index;
        });
        
        for(String key: features){
            pq.add(new Node(featureMap.get(key), map.getOrDefault(key,0), key));
        }
        String[] ans = new String[pq.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = pq.poll().str;
        }
        for(String s: ans){
            System.out.print(s+" ");
        }
    }
     
    static class Node{
        int index;
        int freq;
        String str;
        public Node(int _index, int _freq, String _str){
            index = _index;
            freq = _freq;
            str = _str;
        }
    }hmaps

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String[] features = {"cooler", "lock", "touch"};
        String[] responses = {"i like cooler cooler", "lock touch cool", "locker like touch"};
        
        Map<String,Integer> featureMap = new HashMap<>();
        for(int i=0; i<features.length; i++){
            featureMap.put(features[i], i);
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(String response: responses){
            Set<String> set = new HashSet(Arrays.asList(response.split(" ")));
            for(String str: set){
                if(featureMap.containsKey(str))
                    map.put(str, map.getOrDefault(str,0)+1);
            }
        }
        
        Queue<Node> pq = new PriorityQueue<>((a,b)->{
            return a.freq!=b.freq ? b.freq - a.freq : a.index - b.index;
        });
        
        for(String key: features){
            pq.add(new Node(featureMap.get(key), map.getOrDefault(key,0), key));
        }
        String[] ans = new String[pq.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = pq.poll().str;
        }
        for(String s: ans){
            System.out.print(s+" ");
        }
    }
     
    static class Node{
        int index;
        int freq;
        String str;
        public Node(int _index, int _freq, String _str){
            index = _index;
            freq = _freq;
            str = _str;
        }
    }
