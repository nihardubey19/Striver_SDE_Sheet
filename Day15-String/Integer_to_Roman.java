    // Time Complexity : O(n)
    // Space Complexity : O(k), k->13

    public String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length; i++){
            while(num>=values[i]){
                sb.append(symbols[i]);
                num-=values[i];
            }
            if(num==0)
                break;
        }
        return sb.toString();
    }
