    // Using BFS : 
    // Time Complexity : O(n * n) * 4
    // Space Complexit : O(n * n)
     
    // Approach ->1
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges==0) return 0;
        int countMin = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!q.isEmpty()){
            if(freshOranges==0)
                return countMin;
            int size = q.size();
            while(size-- !=0){
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();
                for(int i=0; i<4; i++){
                    int x = dx[i] + row;
                    int y = dy[i] + col;
                    
                    if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==2 || grid[x][y]==0)
                        continue;
                    grid[x][y] = 2;
                    freshOranges--;
                    q.add(new int[]{x,y});
                }
            }
            countMin++;
        }
        return freshOranges==0 ? countMin : -1;
    }

    // Approach -> 2

    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    private int bfs(int[][] grid){
        int m = grid.length, n = grid[0].length;
        Queue<String> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2)
                    queue.add(i+","+j);
                else if(grid[i][j]==1)
                    freshOranges++;
            }
        }

        if(freshOranges == 0)  // if there is no fresh oranges.
            return 0;

        int ans = 0;

        while(!queue.isEmpty()){
            if(freshOranges==0)
                return ans;
            int size = queue.size();
            while(size-- != 0){
                String x = queue.poll();
                int row = Integer.parseInt(x.split(",")[0]);
                int col = Integer.parseInt(x.split(",")[1]);

                if(col>0){
                    if(grid[row][col-1] == 1){
                        grid[row][col-1] = 2;
                        queue.add(row+","+(col-1)); // go left
                        freshOranges--;
                    }
                }
                if(col<n-1){
                    if(grid[row][col+1]==1){
                        grid[row][col+1] = 2;
                        queue.add(row+","+(col+1)); // go right
                        freshOranges--;
                    }
                }
                if(row>0){
                    if(grid[row-1][col]==1){
                        grid[row-1][col] = 2;
                        queue.add((row-1)+","+col); // go up
                        freshOranges--;
                    }
                }
                if(row<m-1){    
                    if(grid[row+1][col]==1){
                        grid[row+1][col] = 2;
                        queue.add((row+1)+","+col); // go down
                        freshOranges--;
                    } 
                }
            }
            ans++;
        }
        return freshOranges==0 ? ans: -1; 
    }
