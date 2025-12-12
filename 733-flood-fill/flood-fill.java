class Solution {
    class Pair {
    int row, col;
    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        if (image[sr][sc] == color) return image;

        //1. Doing by bfs
        int icolor = image[sr][sc];
        int n= image.length;
        int m= image[0].length;
        Queue<Pair> q= new LinkedList<>();
        int[][] vis= new int[n][m];

        //step 1. adding the sr, sc loaction to our queue. and chnage it to 3 in the visited array
        q.add(new Pair(sr, sc)); 
        vis[sr][sc] = color; //fill start

        //BUT also need to maintain the nodes of the ini color in the final array, coz they would never actually change.
         
        for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
        vis[i][j] = image[i][j];
    
    }
}
vis[sr][sc] = color;

        //conditions to be changed: 1.be a neighbor (ajgacent), 2. should have ini color as sr and sc, 
        int[] dr = {-1, 0, 1, 0};
        int[] dc= {0, 1, 0, -1};

        //step 2. Going for bfs
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
        
        q.poll();

        //going to the 4 neighbours:-
        for(int i=0; i<4; i++) //length of dw
        {
            int nr= r+ dr[i];
            int nc= c+ dc[i];

            //bounds check
            if(nc>= 0 && nr >= 0 && nr < n && nc < m && image[nr][nc] == icolor && vis[nr][nc] != color )
            {
                q.add(new Pair(nr, nc));
                vis[nr][nc] = color; //modified the neighbours as well

            }
        }
        }

        return vis;
    }
}







       


















/*class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; // no change needed
        
        int rows = image.length;
        int cols = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;  // color the starting pixel
        
        // Directions: up, right, down, left
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check bounds + same original color
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && 
                    image[nr][nc] == originalColor) {
                    
                    image[nr][nc] = color; // fill new color
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        return image;
    }
}
*/