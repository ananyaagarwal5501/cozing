class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // If board too small, nothing to do
        if (m == 0 || n == 0) return;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Put all border 'O's into queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][n - 1] == 'O') queue.add(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[m - 1][j] == 'O') queue.add(new int[]{m - 1, j});
        }

        // BFS directions
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS from border O's and mark safe region as '#'
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O')
                continue;

            board[r][c] = '#'; // mark safe

            for (int[] d : dirs) {
                queue.add(new int[]{r + d[0], c + d[1]});
            }
        }

        // Step 3: convert remaining O -> X, and # -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // surrounded ones
                else if (board[i][j] == '#') board[i][j] = 'O'; // safe ones
            }
        }
    }
}
