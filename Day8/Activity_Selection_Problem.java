// Time Complexity : O(nlogn) 
// Space Complexity : O(n)

    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<start.size(); i++){
            list.add(new int[]{start.get(i), end.get(i)});
        }
        Collections.sort(list, (a,b)->{
            int diff = a[1] - b[1];
            if(diff==0)
                return a[0] - b[0];
            return diff;
        });
        
        int s = list.get(0)[0];
        int e = list.get(0)[1];
        int count=0, n=start.size();
        for(int i=1; i<n; i++){
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            
            if(x>=e){
                s=x;
                e=y;
                count++;
            }
        }
        return count+1;
    }
