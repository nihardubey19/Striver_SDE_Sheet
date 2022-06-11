    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        
        int s = intervals[0][0];
        int e = intervals[0][1];
        int n = intervals.length;
        
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(e>=start){
                e = Math.max(e,end);
            }else{
                list.add(new int[]{s,e});
                s = start;
                e = end;
            }
        }
        list.add(new int[]{s,e});
        
        int[][] result = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
