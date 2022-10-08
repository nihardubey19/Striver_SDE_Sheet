

    public int compareVersion(String version1, String version2) {
        String[] l1 = version1.split("\\.");
        String[] l2 = version2.split("\\.");
        
        for(int i=0; i<Math.max(l1.length, l2.length); i++){
            Integer x = i<l1.length ? Integer.parseInt(l1[i]) : 0;
            Integer y = i<l2.length ? Integer.parseInt(l2[i]) : 0;
            
            int diff = x.compareTo(y);
            if(diff!=0) return diff;
        }
        return 0;
    }
