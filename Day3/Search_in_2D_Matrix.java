    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat: matrix){
            int n = mat.length;
            if(mat[n-1]>=target){
                int start = 0;
                int end = n-1;
                while(start<=end){
                    int mid = start + (end-start)/2;
                    if(target<mat[mid]){
                        end = mid-1;
                    }else if(mat[mid]<target){
                        start = mid + 1;
                    }else{
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

