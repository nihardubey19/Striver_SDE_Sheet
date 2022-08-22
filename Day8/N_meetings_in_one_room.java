    // Time Complexity -> O(N) for traversing + O(nlogn) for sorting 
    // Space Complexity -> O(n) for extra n size array of Pair class

    public static int maxMeetings(int start[], int end[], int n)
    {
        Pair[] pair = new Pair[n];
        for(int i=0; i<n; i++){
            pair[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(pair, (p1, p2)->{
            int diff = p1.end - p2.end;
            if(diff==0){
                return p1.start - p2.start;
            }
            return diff;
        });
        
        int st = pair[0].start;
        int ed = pair[0].end;
        int countMeetings = 0;
        for(int i=1; i<n; i++){
            int s = pair[i].start;
            int e = pair[i].end;
            if(s>ed){
                st = s;
                ed = e;
                countMeetings++;
            }
        }
        return countMeetings+1;
    }
    
    static class Pair{
        int start;
        int end;
        public Pair(int _start, int _end){
            start = _start;
            end = _end;
        }
    }
