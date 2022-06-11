   //  right rotation
   // 1. transpose of matrix 
   // 2. Reverse rows of matrix
 

   // if we want left rotation
   // 1. transpose
   // 2. reverse columns of matrix 

   public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==1)
            return;
        
        // transpose of matrix
        transpose(matrix, n);
        
        // reverse rows of matrix
        reverse(matrix, n);
    }
    
    private void transpose(int[][] matrix, int n){
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reverse(int[][] matrix, int n){
        for(int[] mat: matrix){
            int i=0, j=mat.length-1;
            while(i<j){
                int temp = mat[i];
                mat[i] = mat[j];
                mat[j] = temp;
                i++;
                j--;
            }
        }
    }
