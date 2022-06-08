// Using two set : 

public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }

// Using O(1) space : 

public void setZeroes(int[][] matrix) {
        boolean firstCol = false, firstRow = false;
        
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==0){
                firstCol = true;
                break;
            }
        }
        
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[0][j]==0){
                firstRow = true;
                break;
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(firstCol){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(firstRow){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }

