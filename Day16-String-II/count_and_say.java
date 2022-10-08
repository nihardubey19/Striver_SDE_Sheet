
    public String countAndSay(int n) {
        if(n==1) return "1";
        else if(n==2) return "11";
        String s = "11";
        for(int i=3; i<=n; i++){
            s = fun(s);
        }
        return s;
    }
    
    private String fun(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(prev==s.charAt(i)){
                count++;
            }else{
                sb.append(count+""+prev);
                count=1;
            }
            prev = s.charAt(i);
        }
        sb.append(count+""+prev);
        return sb.toString();
    }
