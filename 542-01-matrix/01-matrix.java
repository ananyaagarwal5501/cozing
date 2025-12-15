//BFS
class Solution {
    class Pair {
    int row, col, step;
    Pair(int r, int c, int s) {
        row = r; col = c; step = s;
    }
}

    public int[][] updateMatrix(int[][] mat) 
    {
        int m= mat.length;
        int n= mat[0].length;

        Queue<Pair> q= new LinkedList<>();
        boolean[][] vis= new boolean[m][n]; //0 -> true
        int[][] dist= new int[m][n];
        //int step=0;

        //to find the starting points, need to run once thrpugh the given matrix
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0) //starting points
                {
                    q.add(new Pair(i,j, 0)); //1. add to q
                    vis[i][j] = true; //2. all converted to 0
                }
                else
                {
                    vis[i][j] = false;
                }
            }
        }

        //bfs
        while(!q.isEmpty())
        {
            int r= q.peek().row;
            int c= q.peek().col;
            int step= q.peek().step; ///////////////

            q.remove(); //nikla bahar, pakdo bsd wale ko
            dist[r][c] = step;//jo bhi unka step tha, wo mark kar diya in the dist matrix

            //ab jaenge padosi ke pas
            int[] delr= {-1, 0, 1 ,0};
            int[] delc= {0, 1, 0, -1};

            for(int i=0; i<4; i++)
            {
            int nr= r+ delr[i];
            int nc= c+ delc[i];
            
            //checking the padosis and then adding them to q and marking vis.
            if(nr>=0 && nr < m && nc>=0 && nc< n && vis[nr][nc] != true )
            {
            q.add(new Pair(nr, nc, step+1));
            vis[nr][nc] = true;
            }
            }
        }
        return dist;
    }
    
}







/*class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Push all 0s in queue first (multi-source BFS)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 4 directions
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // within boundary + not visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + 1; // distance = parent + 1
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }
}

*/