//dfs
class Solution {
    public void solve(char[][] board) 
    {
        //naap
        int m = board.length;
        int n= board[0].length;

        //the needful
        int[][] vis= new int[m][n];

        int[] dr= {-1, 0, 1, 0};
        int[] dc= {0, 1, 0, -1};
        //finding the starting points: found on boundaries, at rows: [0][j], [n-1][j]
        //a. traversing on boundaries

         //rows:
          for(int j=0; j<n; j++)
            {
                //1st row
                if(vis[0][j] == 0 && board[0][j]== 'O')
                {
                    //agar O aaya-> chack its neighbours now:
                    dfs(0, j, vis, board, dr, dc);
                }
                //last row
                if(vis[m-1][j] == 0 && board[m-1][j] == 'O')
                {
                    dfs(m-1, j, vis, board, dr, dc);
                }
            }
         //cols:
          for(int i=0; i<m; i++)
            {
                //1st col
                if(vis[i][0] == 0 && board[i][0] == 'O')
                {
                    dfs(i, 0, vis, board, dr, dc);
                }
                //last col
                if(vis[i][n-1] == 0 && board[i][n-1] == 'O')
                {
                    dfs(i, n-1, vis, board, dr, dc);
                }
            }

        //b. now the whole matrix check for the inside O's
        for(int i=0; i<m ;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == 'O' && vis[i][j] == 0)
                {
                    board[i][j] = 'X';
                }
            }
        }
       
    }
        
        //dfs : jaega neighbours ke pass naa
        public void dfs(int r, int c, int vis[][], char board[][], int dr[], int dc[])
        {
            //pehle mark the aya one bhaii
            vis[r][c] = 1;

            int m = board.length;
            int n= board[0].length;
            //neighbours hai ye
            for(int i=0; i<4; i++)
            {
                int nr= r+ dr[i];
                int nc= c+ dc[i];

                if(nr>=0 && nr<m && nc>= 0 && nc<n && board[nr][nc]== 'O' && vis[nr][nc] != 1)
                {
                    dfs(nr, nc, vis, board, dr, dc);
                }
            }
        }
}
            
     