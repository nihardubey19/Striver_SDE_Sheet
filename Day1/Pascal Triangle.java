    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> l = new ArrayList<>();
            if(i==0)
                l.add(1);               
            else{
                l.add(1);
                for(int j=0; j<ans.get(i-1).size()-1; j++){
                    int x = ans.get(i-1).get(j);
                    int y = ans.get(i-1).get(j+1);
                    l.add(x+y);
                }    
                l.add(1);
            }            
            ans.add(l);
        }
        return ans;
    }
