//bfs
class Solution {
    class Pair{
        int row;
        int col;
        Pair(int r, int c)
        {
            row = r;
            col = c;
        }

    }
    public int numEnclaves(int[][] grid) 
    {
        //naap
        int m= grid.length;
        int n= grid[0].length;
        int count=0;

        //the needfuls
        Queue<Pair> q= new LinkedList<>();
        int[][] vis= new int[m][n];

        //the starting points: at the boundaries, r=0, r=m-1 and c=0, c= n-1
        for(int i=0; i< m; i++)
        {
            for(int j=0; j< n; j++)
            {
            //1st row
            if(i==0 || j==0 || i== m-1 ||  j== n-1)
            {
                if(grid[i][j] == 1)
                {
                q.add(new Pair(i,j)); // 1.put them in q
                vis[i][j] = 1; //2.mark them visited
                }
            }
            }           
        }

        //ab bfs chalu, on the neighbours of each in q
        int[] dr= {-1, 0, 1, 0};
        int[] dc= {0, 1, 0, -1};

    while(!q.isEmpty()) {
        int r = q.peek().row;
        int c = q.peek().col;
        q.remove(); //hata diye

        for(int i=0; i< 4; i++) //agye saarey padosiis
        {
            int nr= r+ dr[i];
            int nc= c+ dc[i];

            //now going for the padosi, if they are of use, 
            //if yes, keep them in q and mark in vis
            //otherwise, again remove an element

            if(nr>=0 && nr< m && nc>= 0 && nc< n && grid[nr][nc] == 1 && vis[nr][nc]!= 1)
            {
                q.add(new Pair(nr, nc));
                vis[nr][nc] = 1; 
            }
        }
    }
       
        //now going through the matrix
        for(int i=0; i< m; i++)
        {
            for(int j=0; j< n; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] != 1)
                {
                    count++;
                }
            }
        }

    
     return count;
    }

}

        
















/*class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Step 1: DFS from boundary land → mark all reachable lands
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 1 && !visited[r][0])
                dfs(r, 0, grid, visited);
            if (grid[r][cols - 1] == 1 && !visited[r][cols - 1])
                dfs(r, cols - 1, grid, visited);
        }

        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1 && !visited[0][c])
                dfs(0, c, grid, visited);
            if (grid[rows - 1][c] == 1 && !visited[rows - 1][c])
                dfs(rows - 1, c, grid, visited);
        }

        // Step 2: Count the land NOT visited (i.e., enclaves)
        int enclaves = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c])
                    enclaves++;
            }
        }

        return enclaves;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;

        dfs(r - 1, c, grid, visited); // up
        dfs(r + 1, c, grid, visited); // down
        dfs(r, c - 1, grid, visited); // left
        dfs(r, c + 1, grid, visited); // right
    }
}
*/
